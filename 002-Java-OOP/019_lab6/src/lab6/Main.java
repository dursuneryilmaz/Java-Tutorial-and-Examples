package lab6;

public class Main {

	public static void main(String[] args) {

		GeometricObject[] array = { new Square(2.0), new Circle(5.0), new Square(5.0), new Rectangle(3, 4),
				new Square(4.5) };

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].toString());

			if (array[i] instanceof Square) {
				Square temp = (Square) array[i];
				temp.howToColor();
			}
		}
	}
}
