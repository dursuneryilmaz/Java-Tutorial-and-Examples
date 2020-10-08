package classes;
/*
 * a class is an object in computer programming which represents real word object/things 
 * classes can be separated into two type. action classes and attribute classes
 * action classes contain methods, attribute classes contains attribute
 * if used class is not in the same package it should be imported
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// create product object using new key word, fill the product instance attributes
		Product product = new Product();
		product.id = 1;
		product.name = "Laptop";
		product.description = "8th Gen Monster Laptop";
		product.price = 5678.4f;
		product.stockAmount = 100;
		
		// print the object attributes
		System.out.println("Product: "+product.id+" "+product.name+" "+product.description+" "+product.price+" "+product.stockAmount);
		
		
		// get a ProductManager instance to manage product actions
		// demonstrates very simple way
		ProductManager productManager = new ProductManager();
		productManager.Create(product);
		productManager.Read(product);
		productManager.Update(product);
		productManager.Delete(product);
		
		
		
	}

}
