package fileHandling;

/*
 *	The File class from the java.io package, allows us to work with files.
	To use the File class, create an object of the class, and specify the filename or directory name
 *  The File class has many useful methods for creating and getting information about files
 *  To create a file in Java, you can use the createNewFile() method.
	This method returns a boolean value: true if the file was successfully created, and false if the file already exists.
 *	FÝle handling methods throw IOException use try-catch or throw key on methods
 * 
 * */
import java.io.*; // import all classes under the java.io package
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		createFile();
		getFileInfo();
		readFile();
		writeFile();
		readFile();
		//deleteFile();
	}

	public static void createFile() {
		File file = new File("src\\fileHandling\\students.txt");
		try {
			if (file.createNewFile()) {
				System.out.println("File Created.");
			} else {
				System.out.println("File Already Exist!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getFileInfo() {
		File file = new File("src\\fileHandling\\students.txt");
		if (file.exists()) {
			System.out.println("File Name : " + file.getName());
			System.out.println("File Full Path : " + file.getAbsolutePath());
			System.out.println("File Relative Path : " + file.getPath());
			System.out.println("is Writable : " + file.canWrite());
			System.out.println("is Readable : " + file.canRead());
			System.out.println("File Size (byte) : " + file.length());
		}
	}

	// we use the Scanner class to read the contents of the text file
	public static void readFile() {
		File file = new File("src\\fileHandling\\students.txt");
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// we use the BufferedWriter class together with its write() method to write
	// some text to the file
	// also FileWriter class can be used
	public static void writeFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src\\fileHandling\\students.txt", true));
			writer.newLine();
			writer.write("Ali");
			System.out.println("File Wrirte Completed.");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To delete a file in Java, use the delete() method
	public static void deleteFile() {
		File file = new File("src\\fileHandling\\students.txt");
		if (file.delete()) {
			System.out.println("Deleted the file: " + file.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}

	}

}
