package functions;

/* Functions/Methods
 * main is a function and start point to program
 * methods have a return type which can be void if no return and any primitive type or any complex object. see more after OOP
 * methods and variables have a access modifier which can be (public, protected, private) one of them
 * java works on static and non static memory areas. there is no access between them. study about it.
 * function can take parameter argument depends on problem, if function returns something we should store it a compatible variable to use 
 * 
 */
public class main {
	// main is also function
	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 5, 7, 9, 0 };
		int findingNumber = 6;
		// void return type and take parameter
		findNumber(numbers, findingNumber);
		// integer return type and take parameter, store the return in the variable and print
		int length = findArrayLength(numbers);
		System.out.println("Length of Array: "+ length);
		// void return type and take no parameter
		simpleMethod();
	}
	
	// function to determine given integer does exist in given array or not
	public static void findNumber(int[] numbers, int findingNumber) {
		// existing condition
		boolean isExist = false;
		// check all array element one by one with finding number
		for (int num : numbers) {
			if (num == findingNumber) {
				// if any match change the existing condition to print correct message
				isExist = true;
				// stop checking
				break;
			}
		}
		// print relevant message 
		if (isExist) {
			printMessage(findingNumber + ": does exist.");
		} else {
			printMessage(findingNumber + ": does not exist!");
		}
	}
	
	// simple function to print message
	public static void printMessage(String message) {
		System.out.println(message);
	}

	//find and return length of given array as parameter
	public static int findArrayLength(int[] numbers) {
		// finding array length
		return numbers.length;
	}
	
	//simple method
	public static void simpleMethod() {
		System.out.println("This method does not take parameter and does not return anything!!");
	}
}
