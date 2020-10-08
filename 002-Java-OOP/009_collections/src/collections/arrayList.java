package collections;
/*
 * ArrayList
 * The ArrayList class is a resizable array, which can be found in the java.util package. It should be imported
 * The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one). 
 * While elements can be added and removed from an ArrayList whenever you want. 
 *
 * */

import java.util.ArrayList;

public class arrayList {
	public static void main(String[] args) {
		// ArrayList usage sytax
		ArrayList items = new ArrayList();
		// element adding to ArrayList
		items.add(1);
		items.add(10);
		items.add("Ankara");
		// ArrayList size
		System.out.println("Size of ArrayList: "+items.size());
		// Element changing in ArrayList using index number
		items.set(2,100);
		// element remove using index
		System.out.println("item removed at index 0: "+items.remove(0));
		// element fetch using index
		System.out.println("Item in index 0: "+items.get(0));
		
		// foreach loop throughout ArrayList
		for (Object i : items) {
			System.out.println("item in Array List -> "+i);
		}
		// clear the ArrayList
		items.clear();
		System.out.println("ArrayList cleared!");
		System.out.println("Size of ArrayList: "+items.size());
	}
}
