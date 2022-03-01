import java.util.ArrayList;

public class Model {

	public Polinom adunare(Polinom p1, Polinom p2) {
		Polinom result = new Polinom("");
		p1.sortByPower();
		p2.sortByPower();
		for (Monom m1 : p1.getMonoame()) {
			int ok = 0;
			for (Monom m2 : p2.getMonoame()) {
				if (m1.getExponent() == m2.getExponent()) {
					Monom rez = new Monom(m1.getCoeficient() + m2.getCoeficient(), m1.getExponent());
					result.add(rez);
					ok = 1;
				}
			}
			if (ok == 0)
				result.add(m1);
		}
		for (Monom m2 : p2.getMonoame()) {
			int ok = 0;
			for (Monom m1 : result.getMonoame()) {
				if (m1.getExponent() == m2.getExponent())
					ok = 1;
			}
			if (ok == 0)
				result.add(m2);
		}
		result.sortByPower();
		return result;
	}

	public Polinom scadere(Polinom p1, Polinom p2) {
		Polinom result = new Polinom("");
		p1.sortByPower();
		p2.sortByPower();
		for (Monom m1 : p1.getMonoame()) {
			int ok = 0;
			for (Monom m2 : p2.getMonoame()) {
				if (m1.getExponent() == m2.getExponent()) {
					Monom rez = new Monom(m1.getCoeficient() - m2.getCoeficient(), m1.getExponent());
					result.add(rez);
					ok = 1;
				}
			}
			if (ok == 0)
				result.add(m1);
		}
		for (Monom m2 : p2.getMonoame()) {
			int ok = 0;
			for (Monom m1 : result.getMonoame()) {
				if (m1.getExponent() == m2.getExponent())
					ok = 1;
			}
			if (ok == 0)
				result.add(new Monom(-m2.getCoeficient(),m2.getExponent()));
		}
		result.sortByPower();
		return result;
	}

	public Polinom inmultire(Polinom p1, Polinom p2) {
		Polinom result_partial = new Polinom("");
		Polinom result = new Polinom("");
		p1.sortByPower();
		p2.sortByPower();
		for (Monom m1 : p1.getMonoame())
			for (Monom m2 : p2.getMonoame())
				result_partial
						.add(new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getExponent() + m2.getExponent()));

		for (Monom m1 : result_partial.getMonoame()) {
			int ok = 0;
			for (Monom m2 : result.getMonoame()) {
				if (m1.getExponent() == m2.getExponent()) {
					ok = 1;
					m2.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
				}
			}
			if (ok == 0)
				result.add(m1);
		}

		result.sortByPower();
		return result;
	}

	public ArrayList<Polinom> impartire(Polinom p1, Polinom p2) {
		Polinom r = new Polinom("");
		Polinom q = new Polinom("");
		
		p1.sortByPower();
		p2.sortByPower();
		ArrayList<Polinom> results = new ArrayList<Polinom>();
		if (p2.getMonoame() != null) {
			r = p1;
			while (r.getMonoame() != null
					&& r.getMonoame().get(0).getExponent() >= p2.getMonoame().get(0).getExponent()) {
				Monom t = new Monom(0, 0);
				float coef = (r.getMonoame().get(0).getCoeficient() / p2.getMonoame().get(0).getCoeficient());
				int power = r.getMonoame().get(0).getExponent() - p2.getMonoame().get(0).getExponent();
				t.setCoeficient(coef);
				t.setExponent(power);
				Polinom p = new Polinom("");
				p.getMonoame().add(t);
				q.getMonoame().add(new Monom(coef, power));
				r = this.scadere(r, this.inmultire(p, p2));
				while (r.getMonoame().get(0).getCoeficient() == 0) {
					r.getMonoame().remove(0);
					if (r.getMonoame().size() == 1)
						break;
				}

			}
		}
		results.add(q);
		results.add(r);
		return results;
	}

	// 2x^2+3x^1+2x^0
	// 2x^3+2x^1-3x^0
	public Polinom derivare(Polinom p) {
		p.sortByPower();
		
		Polinom result = new Polinom("");
		for (Monom m : p.getMonoame()) {
			result.add(new Monom(m.getCoeficient() * m.getExponent(), m.getExponent() - 1));
		}
		result.sortByPower();
		return result;
	}

	public Polinom integrare(Polinom p) {
		p.sortByPower();
		Polinom result = new Polinom("");
		for (Monom m : p.getMonoame()) {
			result.add(new Monom(m.getCoeficient() / (m.getExponent() + 1), m.getExponent() + 1));
		}
		result.sortByPower();
		return result;
	}

	public String print(Polinom p) {
		String s = "";
		for (Monom m : p.getMonoame()) {
			if (m.getCoeficient() != 0) {
				if (m.getExponent() == 0) {
					s = s + (int) m.getCoeficient() + "+";
				} else if (m.getExponent() == 1) {
					s = s + (int) m.getCoeficient() + "x+";
				} else
					s = s + (int) m.getCoeficient() + "x^" + m.getExponent() + "+";
			}
		}
		if (s != "")
			s = s.substring(0, s.length() - 1);
		return s;
	}

	public String printFloat(Polinom p) {
		String s = "";
		for (Monom m : p.getMonoame()) {
			if (m.getCoeficient() != 0) {
				if (m.getExponent() == 0) {
					s = s + m.getCoeficient() + "+";
				} else if (m.getExponent() == 1) {
					s = s + m.getCoeficient() + "x+";
				} else
					s = s + m.getCoeficient() + "x^" + m.getExponent() + "+";
			}
		}
		if (s != "")
			s = s.substring(0, s.length() - 1);
		return s;
	}
}
