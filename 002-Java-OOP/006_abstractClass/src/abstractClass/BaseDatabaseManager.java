package abstractClass;
/*
 * The abstract keyword is a non-access modifier, used for classes and methods:
		Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
		Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).
 * An abstract class can have both abstract and regular methods.
 * 
 * */

public abstract class BaseDatabaseManager {
	// below method must overridden in child class depends on their own behaviour
    public abstract void getData();
    
}
