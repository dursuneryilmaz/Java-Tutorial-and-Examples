package collections;
/*
 * TypeSafeArrayList is also array list but it items limited just one type 
 * All ArrayList methods can be used
 * 
 * */

import java.util.ArrayList;
import java.util.Collections;

public class typeSafeArrayList {
	public static void main(String[] args) {
		// syntax
		ArrayList<String> cities = new ArrayList<String>();
		cities.add("Ankara");
		cities.add("İstanbul");
		cities.add("İzmir");
		cities.add("Aydın");
		// remove
		cities.remove("İstanbul");
		// sorting
		Collections.sort(cities);
		
		for (String sehir : cities) {
			System.out.println(sehir);
		}

	}
}
