package arrays;

/*
 * One dimensional array
 * Array index, starts from 0 so last index of the array is "length of array" -1.
 * Items of array can be taken from any where e.g. console
 * 
 * 
 * */
public class oneDimArray {

	public static void main(String[] args) {
		// Define data type of array item, use [] to make array, give a variable name to it instantiate using new keyword, write type of array and length
		// of array
		String[] colours = new String[3];

		// Assign the values to each array index
		colours[0] = "Red";
		colours[1] = "Green";
		colours[2] = "Blue";

		System.out.println("First colour array items");
		// Reach all array elements one by one using for loop
		for (int i = 0; i < colours.length; i++) {
			// print the i'th element value
			System.out.println("Colur: " + colours[i]);
		}

		System.out.println("\nSecond colour array items");

		// below code is the same array can defined like below
		// this array definition is more similar to storing method of values in RAM
		String[] colours2 = { "Yellow", "Purpel", "Pink" };
		for (int i = 0; i < colours2.length; i++) {
			System.out.println("Colour2: " + colours2[i]);

		}

		// for-each loop usage
		System.out.println("\nFor-each loop print");
		//dataType,variableName : arrayName
		for (String colour      : colours2) {
			System.out.println("Colour2: " + colour);
		}
	}

}
