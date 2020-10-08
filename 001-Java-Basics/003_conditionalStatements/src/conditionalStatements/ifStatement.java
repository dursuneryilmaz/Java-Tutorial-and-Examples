package conditionalStatements;

import java.util.Scanner;

/*
 * conditional if statements
 * grade calculation
 * 
 * */
public class ifStatement {

	public static void main(String[] args) {
		// Creating a scanner object to get input from user via console
		Scanner input = new Scanner(System.in);
		
		// declaring variables to store given input grades and calculation results
		int x, y, z, min, max;
		float avg;
		System.out.println("Enter a integer grade and press enter three times:");	
		// getting integer to variable from console
		// in grade domain grades cannot be bigger than 100 but i dont check it 
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		// scanner object input, should be closed after used
		input.close();
		
		System.out.println("For the Entered Grades:"+x+" "+y+" " +z);	
		// variable value assignment, assign the value of max initially value of x
		max = x;
		
		// if value of z is bigger value of max then assign the new value of max from value of z
		if(z > max){
			max = z;
		}
		// if value of y is bigger value of max then assign the new value of max from value of y
		if(y > max){
			max = y;
		}
		// if above two if statement is not true inform the user given first grade is bigger
		else {
			System.out.println("\nFirst grade is largest!\n");
		}
		System.out.println("Largest is: "+max);
		
		// Same steps for finding minimum, if statements controls the smaller grade
		min = x;
		if(y < x){
			min = y;
		}
		if(z < x){
			min = z;
		}
		else {
			System.out.println("\nFirst grade is smallest!\n");
		}
		System.out.println("Smallest is: "+min);
		
		// average calculation 
		avg = (x+y+z)/3.0f;
		System.out.println("Avarage is: "+avg);
		
		
		
		
		
		
	}

}
