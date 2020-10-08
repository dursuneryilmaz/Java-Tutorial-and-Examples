package arrays;

/*
 * two dimensional array
 * Dimension lengths multiplied by each other determines size of array e.g. 3X3=9 item
 * First dimension is y dimension.
 * 
 * Multidimensional array can be created same way
 * 
 * 
 * */
public class twoDimArray {

	public static void main(String[] args) {
		// define data type of array item, use [][] to make 2Darray, give a variable
		// name to it
		// created array, instantiate using new keyword, write type of array and
		// rowLength and colLenght of array

		String[][] colours = new String[3][3];

		// assign the values to each array index
		/*
		 * 
		 * { {"Red", null, null}, {null , "Green",null}, {null , null, "Blue"} }
		 * 
		 * below assignments create above array
		 */
		colours[0][0] = "Red";
		colours[1][1] = "Green";
		colours[2][2] = "Blue";

		System.out.println("Colour array items");
		// Reach all array elements one by one using nested two for loops
		// the outer for loop for iterating rows, the inner for loop for iteration
		// columns in a row

		for (int i = 0; i < colours.length; i++) {
			for (int j = 0; j < colours.length; j++) {
				// print the [i][j]'th element value
				System.out.print("Colour at [" + i + "," + j + "]: " + colours[i][j] + "\t");
				// System.out.println("Colour at ["+i+","+j+"]: " + colours[i][j]);
			}
			System.out.println("");
		}

	}

}
