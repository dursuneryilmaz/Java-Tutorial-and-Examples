package statics;
/*
 * static-innerClass-package
 * A package in Java is used to group related classes. Think of it as a folder in a file directory. We use packages to avoid name conflicts, and to write a better maintainable code. Packages are divided into two categories:
 * 	Built-in Packages (packages from the Java API)
  	User-defined Packages (create your own packages)
 * To use a class or a package from the library, you need to use the import keyword
 * Static object can created once in ram and stand there until program stop, static used in utility actions
 * 
 */

import innerClass.DatabaseHelper;

public class Main {

	public static void main(String[] args) {
		ProductManager manager = new ProductManager();
		Product product = new Product();
		product.price = 10;
		product.name = "";

		manager.add(product);

		// inner class and statics used together
		DatabaseHelper.Connection.createConnection();
		DatabaseHelper.Crud.Update();

		// class and method can be used without importing a package
		innerClass.DatabaseHelper.Connection.createConnection();
	}
}
