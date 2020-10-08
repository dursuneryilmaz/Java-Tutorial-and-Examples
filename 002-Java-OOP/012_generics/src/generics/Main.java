package generics;
/*
 *  Java Generic methods and generic classes enable programmers to specify, with a single method declaration,
    a set of related methods, or with a single class declaration, a set of related types, respectively.
 * 
 *  simple reconstruction of generic ArrayList class to understand the approach
 * */

public class Main {

    public static void main(String[] args) {
    	// create a customer list 
	    MyList<Customer> customers=new MyList<Customer>();
	    customers.add(new Customer());
	    customers.add(new Customer());
	    
	    // create a city list
	    MyList<City> cities = new MyList<City>();
	    cities.add(new City());
	    cities.add(new City());
    }
}
