package conditionalStatements;

import java.util.Scanner;

/*
 * conditional switch statements
 * day of week
 * 
 * */
public class switchStatement {

	public static void main(String[] args) {
		// Creating a scanner object to get input from user via console
		Scanner input = new Scanner(System.in);
		int dayNumber;
		System.out.println("Enter a day number range 1 to 7:");	
		dayNumber = input.nextInt();
		
		/* Scanner can read all primitive data types from console 
		 * 
		 *  byte b = input.nextByte();
		 *	float f = input.nextFloat();
		 *	String s = input.toString();
		 *	long l = input.nextLong();
		 *	double d = input.nextDouble();
	     *	boolean bool = input.nextBoolean(); 
		 */
		// close Scanner when used
		input.close();
		
		/* 
		 * switch checks the given variable value with cases and matched case code block will executed
		 * the with break code switch ends.
		 * given variable value in switch can be any primitive data type
		 * 
		 */
		switch (dayNumber) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;

		default:
			System.out.println("There is no day at: "+ dayNumber);
			break;
		}
		
	}

}
