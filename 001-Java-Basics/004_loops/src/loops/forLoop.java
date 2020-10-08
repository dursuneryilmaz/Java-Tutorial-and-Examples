package loops;

import java.util.Scanner;
/*
 * for loop
 * printing given string for given number of times by user
 * 
 * */
public class forLoop {

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
		
		// for loop syntax is below. int i counter can be declared and initialized outside the for loop if you do that, don't declare in if loop again
		// int i = 0
		// start point ;limit     ; step size	
		for(int i= 0;  i<rowNumber; i++) {
			System.out.println("Given String : "+userInput);
		}
		
		// There is also a "for-each" loop, which is used exclusively to loop through elements in an array.
		// I use it after array in examples
		
	}

}
