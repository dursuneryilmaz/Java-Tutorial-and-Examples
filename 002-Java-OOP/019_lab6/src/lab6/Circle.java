package lab6;

public class Circle extends GeometricObject {

	private double radius;

	public Circle() {

	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public String toString() {
		return "[circle] radius = " + getRadius() + " created on " + getDateCreated() + "\n" + "color : " + getColor()
				+ " and " + " filled " + isFilled() + "\n" + "Area ofobject is " + getArea() + "\n";
	}

}
