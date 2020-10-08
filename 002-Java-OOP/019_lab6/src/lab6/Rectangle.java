package lab6;

public class Rectangle extends GeometricObject {

	private double width;
	private double height;

	public Rectangle() {

	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return 2 * (width + height);
	}

	public String toString() {

		return "[rectangle] width: " + getWidth() + " height: " + getHeight() + " created on " + getDateCreated() + "\n"
				+ "color : " + getColor() + " and " + " filled " + isFilled() + "\n" + "Area ofobject is " + getArea()
				+ "\n";
	}
}
