package abstractClass;
/*
 * Abstract Class
 * Abstract class is also class, they also uses extends key word
 * one class can extends only one abstract class at a time like normal class
 * Data abstraction is the process of hiding certain details and showing only essential information to the user.
 * Abstraction can be achieved with either abstract classes or interfaces
 * 
 * */

public class Main {

    public static void main(String[] args) {
	    CustomerManager customerManager = new CustomerManager();
	    customerManager.databaseManager = new MySqlDatabaseManager();
	    customerManager.getCustomers();
    }
}
