package lab5;

import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Triangle myTriangle = new Triangle();
		System.out.print("Enter three sides: ");
		myTriangle.setSide1(input.nextDouble());
		myTriangle.setSide2(input.nextDouble());
		myTriangle.setSide3(input.nextDouble());

		System.out.print("Enter the colour: ");
		myTriangle.colour = input.next();

		System.out.print("Enter a boolean value for filled: ");
		myTriangle.filled = input.nextBoolean();

		System.out.println();

		System.out.println(myTriangle.toString());
	}
}
