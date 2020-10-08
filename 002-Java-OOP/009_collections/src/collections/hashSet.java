package collections;
/*
 * A HashSet is a collection of items where every item is unique, and it is found in the java.util package
 * HasSet can be created different type of object.e.g.(String, int,double or custom class);
 * */

import java.util.HashSet;

public class hashSet {
	public static void main(String[] args) {
		HashSet<String> cars = new HashSet<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("BMW");
		cars.add("Mazda");
		System.out.println(cars);

		// check existance returns boolean
		System.out.println("HashSet contains Mazda: " + cars.contains("Mazda"));
		// remove
		System.out.println("Volvo removed from HashSet: " + cars.remove("Volvo"));
		// size
		//cars.size();
		System.out.println("HashSet number of items: "+cars.size());

		// loop through
		for (String i : cars) {
			System.out.println("item-> "+i);
		}
		// clear
		cars.clear();
		System.out.println("All items removed!!");
		// size
		System.out.println("HashSet number of items: "+cars.size());

	}
}
