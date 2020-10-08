package lab5;

import java.util.Date;

public class Triangle extends GeometricObject {

	public Triangle() {
		dateCreated = new java.util.Date();
	}

	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		dateCreated = new java.util.Date();
	}

	double getArea() {
		double s, area;
		s = (side1 + side2 + side3) / 2;
		area = Math.sqrt(s * ((s - side1) * (s - side2) * (s - side3)));
		return area;
	}

	double getPerimeter() {
		return side1 + side2 + side3;
	}

	public double getSide1() {
		return super.getSide1();
	}

	public void setSide1(double side1) {
		super.setSide1(side1);
	}

	public double getSide2() {
		return super.getSide2();
	}

	public void setSide2(double side2) {
		super.setSide2(side2);
	}

	public double getSide3() {
		return super.getSide3();
	}

	public void setSide3(double side3) {
		super.setSide3(side3);
	}

	public Date getDateCreated() {
		return super.getDateCreated();
	}

	public String toString() {
		return "The area is: " + getArea() + "\nThe perimeter is: " + getPerimeter() + "\nTriangle: side1 = "
				+ getSide1() + " side2 = " + getSide2() + " side3 = " + getSide3() + " and create on "
				+ getDateCreated() + "\nTriangle colour: " + colour + "and filled: " + filled;
	}

}
