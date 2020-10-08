package loops;

import java.util.Scanner;
/*
 * while loop
 * same example with for loop example
 * while loop can be used any desired condition which is not integer
 * 
 * */
public class whileLoop {

	public static void main(String[] args) {
		// Get a scanner object to get input from user via console
		Scanner input = new Scanner(System.in);
		// Ask desired number of print
		System.out.print("How many times do you want to print:");
		// Get number of print
		int rowNumber = input.nextInt();
		// Ask a String to print
		System.out.println("Enter a String:");
		// Get value of given string and assign to variable
		String userInput = input.next();
		// Don't forget to close input
		input.close();
		
		// While loop condition must be declared outside the while loop and it should be change in the loop for finishing loop and skip next lines of code 
		// if condition does not change in the loop it will never finish and it called infinite loop
		int i = 0;
		while (i< rowNumber) {
			System.out.println("Given String : "+userInput);
			// means i = i+1
			i++;
		}
	}
}
