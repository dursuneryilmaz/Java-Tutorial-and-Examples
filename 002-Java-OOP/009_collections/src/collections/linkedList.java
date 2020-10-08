package collections;
/*
 * The LinkedList class is almost identical to the ArrayList
 * The LinkedList class has all of the same methods as the ArrayList class because they both implement the List interface. 
 * The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. 
   If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.
 * The LinkedList stores its items in "containers." The list has a link to the first container and each container has a link to the next container in the list. 
   To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.
 * 
 * */

import java.util.LinkedList;

public class linkedList {
	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		System.out.println(cars);

		// Adds an item to the beginning of the list.
		cars.addFirst("TOGG");
		// Add an item to the end of the list
		cars.addLast("Mercedes");
		// print new list
		System.out.println(cars);
		
		// Get the item at the beginning of the list
		System.out.println("First: "+cars.getFirst());
		// Get the item at the end of the list	
		System.out.println("Last: "+cars.getLast());
		// Remove an item from the beginning of the list.
		cars.removeFirst();
		// Remove an item from the end of the list
		cars.removeLast();
		System.out.println(cars);
	
	}
}
