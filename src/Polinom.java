import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
	private ArrayList<Monom> monoame = new ArrayList<Monom>();
	private ArrayList<String> list = new ArrayList<String>();

	public Polinom(String polinom) {
		Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
		Matcher matcher = pattern.matcher(polinom);
		while (matcher.find()) {
			String monom = matcher.group(1);
			// Monom a= new Monom(coefficient, exponent);
			// polinom1.add(a);
			//System.out.println(monom);
			list.add(monom);

		}

		for (String s : list) {
			int i = 0;
			String coef = "";
			String exp = "";
			if (s.charAt(0) == '+') {
				i++;
			}
			if (s.charAt(0) == '-') {
				coef = coef + '-';
				i++;
			}
			while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				coef = coef + s.charAt(i);
				i++;
			}
			i = i + 2;
			while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				exp = exp + s.charAt(i);
				i++;
				if (i > s.length() - 1)
					break;
			}
			Monom a = new Monom(Integer.valueOf(coef), Integer.valueOf(exp));
			monoame.add(a);

			sortByPower();
		}

	}

	public void sortByPower() {
		monoame.sort(new Comparator<Monom>() {
			@Override
			public int compare(Monom m1, Monom m2) {
				if (m1.getExponent() > m2.getExponent())
					return -1;
				return 1;
			}
		});
	}

	public void add(Monom m) {
		monoame.add(m);
	
	}
	public ArrayList<Monom> getMonoame() {
		return monoame;
	}

}
