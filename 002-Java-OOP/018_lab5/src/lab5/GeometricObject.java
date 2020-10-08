package lab5;

public class GeometricObject {
	java.util.Date dateCreated;
	double side1;
	double side3;
	double side2;
	String colour;
	boolean filled;

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

}
