package lab7;

import java.io.*;
import java.util.*;

public class Main {
	public static RandomAccessFile raf;
	private static int i = 1;
	public static Scanner input = new Scanner(System.in);
	private static String id, name, street, city, gender, zip;
	final static int ID_SIZE = 4;
	final static int NAME_SIZE = 32;
	final static int STREET_SIZE = 32;
	final static int CITY_SIZE = 20;
	final static int GENDER_SIZE = 2;
	final static int ZIP_SIZE = 5;
	final static int RECORD_SIZE = (ID_SIZE + NAME_SIZE + STREET_SIZE + CITY_SIZE + GENDER_SIZE + ZIP_SIZE);

	public static void main(String[] args) throws IOException {

		try {
			raf = new RandomAccessFile("address.dat", "rw");
		} catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(1);
		}

		printMenu();

	}

	public static void printMenu() throws IOException {
		int ch = 1;
		boolean cond = true;
		do {
			if (ch == 1 || ch == 2 || ch == 3 || ch == 0) {
				System.out.print(
						"\nMain Menu\n 1:Add addres\n 2:Search address\n 3:List address\n 0:Exit\nEnter a choise:");
				ch = input.nextInt();
				switch (ch) {
				case 1:
					writeAddress();
					break;
				case 2:
					searchAddress();
					break;
				case 3:
					raf.seek(0);
					while (raf.getFilePointer() < raf.length())
						readAddress(raf.getFilePointer());
					break;

				case 0:
					System.out.println("\nprogram Exits.");
					cond = false;
					break;
				default:
					System.out.print("Enter a valid choise:");
					ch = input.nextInt();
					break;
				}
			} else {
				System.out.println("Enter a valid choise:");
				ch = input.nextInt();
			}
		} while (cond);

	}

	public static void writeAddress() {

		System.out.print("Id:");
		id = input.next();

		System.out.print("Name:");
		name = input.next();

		System.out.print("Street:");
		street = input.next();

		System.out.print("City:");
		city = input.next();

		System.out.print("Gender:");
		gender = input.next();

		System.out.print("Zip:");
		zip = input.next();
		try {
			raf.seek(raf.length());
			FixedLengthStringIO.writeFixedLengthString(id, ID_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(name, NAME_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(street, STREET_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(city, CITY_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(gender, GENDER_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(zip, ZIP_SIZE, raf);

			System.out.println("\n1 record added.\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void readAddress(long position) throws IOException {
		raf.seek(position);

		id = FixedLengthStringIO.readFixedLengthString(ID_SIZE, raf);
		name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
		street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE, raf);
		city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE, raf);
		gender = FixedLengthStringIO.readFixedLengthString(GENDER_SIZE, raf);
		zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE, raf);

		System.out.print("\nRecord " + i + "->\n" + "id:" + id + "\n" + "Name:" + name + "\n" + "Street:" + street
				+ "\n" + "City:" + city + "\n" + "Gender:" + gender + "\n" + "Zip:" + zip + "\n");

		i++;
	}

	public static void searchAddress() {

		try {
			raf.seek(0);

			System.out.print("Please enter an ID to search:");
			String id_search = input.next() + "   ";
			while (raf.getFilePointer() < raf.length()) {
				String id_file = FixedLengthStringIO.readFixedLengthString(ID_SIZE, raf);
				// @debug System.out.println(id_file);
				if (id_search.equals(id_file)) {
					// @debug System.out.println("Ok");
					readAddress(raf.getFilePointer() - 2 * ID_SIZE);
					// @debug raf.seek(0);
					break;
				}
				raf.seek(raf.getFilePointer() + 91 * 2);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
