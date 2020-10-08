package lab6;

public class Square extends GeometricObject implements Colorable {
	private double side;

	public Square() {
		side = 0;
	}

	public Square(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getArea() {
		return side * side;
	}

	public double getPerimeter() {
		return 4 * side;
	}

	public void howToColor() {
		System.out.println("Color all four sides \n");
	}

	public String toString() {
		return "[square] side: " + getSide() + " created on " + getDateCreated() + "\n" + "color : " + getColor()
				+ " and " + " filled " + isFilled() + "\n" + "Area ofobject is " + getArea();
	}

}
