package collections;
/*
 * HashMap in java.util package
 * A HashMap, store items in "key/value" pairs, and you can access them by an index of another type
 * One object is used as a key (index) to another object (value).
 * It can store different types: String keys and Integer values, or the same type, like: String keys and String values
 * 
 * */

import java.util.HashMap;

public class hashMap {
	public static void main(String[] args) {
		// Create a HashMap object called capitalCities
		HashMap<String, String> capitalCities = new HashMap<String, String>();

		// Add keys and values (Country, City)
		capitalCities.put("England", "London");
		capitalCities.put("Germany", "Berlin");
		capitalCities.put("Norway", "Oslo");
		capitalCities.put("USA", "Washington DC");
		System.out.println(capitalCities);

		// access an item
		capitalCities.get("England");
		// remove an item
		capitalCities.remove("England");
		// size of hash map
		capitalCities.size();

		// Print keys
		for (String i : capitalCities.keySet()) {
			System.out.println("key-> "+i);
		}
		// Print values
		for (String i : capitalCities.values()) {
			System.out.println("value-> "+i);
		}
		// Print keys and values
		for (String i : capitalCities.keySet()) {
			System.out.println("key: " + i + " value: " + capitalCities.get(i));
		}

		// clear HashMap/remove all items
		capitalCities.clear();
		// size of hash map
		capitalCities.size();

	}
}
