package loops;

import java.util.Scanner;
/*
 * do while loop 
 * sum the entered number with the previous sum, initial sum is equal to 0
 * -1 is exit code so the program cannot sum any number with -1!!
 * */
public class doWhileLoop {

	public static void main(String[] args) {
		//Get a scanner object to get input from user via console
		Scanner input = new Scanner(System.in);
		// initialize a sum variable to store entered numbers sum value and assign it to 0 initially
		int sum = 0;
		// variable to assign entered values from console.
		int givenInt;
		
		// do part of do-while loop runs the code block once without checking any condition in while part 
		// then "while" part runs the code infinitely if the condition is satisfied in while part. if condition does not satisfy, loop will finish
		do {
			// ask to user enter a number 
			System.out.print("Enter a number to sum or (-1) to exit:");
			// assign the value entered to variable
			givenInt = input.nextInt();
			// control the entered value with -1 because -1 is exit code
			if(givenInt != -1) {
				// same as this one -> sum = sum + givenInt 
				// basic summation operation and printing new sum
				sum += givenInt;
				System.out.println("New Sum: "+ sum);
			}
		// while checks condition
		} while (givenInt != -1);
		
		// close console input and show a basic information 
		input.close();
		System.out.println("Program finished!!");
	}
}
