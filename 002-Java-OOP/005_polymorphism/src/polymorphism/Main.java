package polymorphism;
/*
 * Polimorphism
 * Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
 * Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods from another class. 
 * Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.
 * 
 * polymorphism triggers method overriding see Logger classes
 * 
 * simple logger example
 * 
 * */

public class Main {

    public static void main(String[] args) {
    	// CustomerManager Array in array every object has own logger in different type poliymorphism occurs here 
        CustomerManager[] customerManagers = new CustomerManager[] {
        		new CustomerManager(new FileLogger()), 
        		new CustomerManager(new ConsoleLogger()),
        		new CustomerManager(new DatabaseLogger())
        		};
        
        // foreach loop for above array
        for (CustomerManager customerManager:customerManagers){
        	// every customerManager object performs own action with own logger
            customerManager.add();
        }

    }
}