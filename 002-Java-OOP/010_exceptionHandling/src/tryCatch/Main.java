package tryCatch;
/*
 *  When an error occurs, Java will normally stop and generate an error message.
    The technical term for this is: Java will throw an exception (throw an error).
 *  The try statement allows you to define a block of code to be tested for errors while it is being executed.
    The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
    The try and catch keywords come in pairs:
 * 
 * */

public class Main {

	public static void main(String[] args) {
		// try to execute the code inside the try block if an exception thrown	
		try {
			int[] sayilar = new int[] { 1, 2, 3 };
			System.out.println(sayilar[4]);
		}
		// catch the particular exception in catch block and handle it with logging or showing message etc.
		// and prevent the program stop
		// The throw statement is used together with an exception type.
		// There are many exception types available in Java:
		catch (StringIndexOutOfBoundsException exception) {
			System.out.println(exception);
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println(exception);
		} catch (Exception exception) {
			System.out.println("logged : " + exception);
		} finally {
			System.out.println("Try Catch worked");
		}

	}
}
