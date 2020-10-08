package lab1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int x, y, z, min, max;
		System.out.println("Enter three integer:");

		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		System.out.println("For the number:" + x + " " + y + " " + z);
		max = x;
		if (z > max) {
			max = z;
		}
		if (y > max) {
			max = y;
		}
		System.out.println("Largest is: " + max);

		min = x;
		if (y < x) {
			min = y;
		}
		if (z < x) {
			min = z;
		}
		System.out.println("Smallest is: " + min);

		System.out.println("Avarage is: " + (x + y + z) / 3);
		input.close();
	}

}
