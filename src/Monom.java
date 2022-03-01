
public class Monom {

	private float coeficient;
	private int exponent;

	public Monom(float coeficient, int exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}

	public float getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(float coeficient) {
		this.coeficient = coeficient;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	@Override
	public String toString() {
		return "Monom [coeficient=" + coeficient + ", exponent=" + exponent + "]";
	}

}
