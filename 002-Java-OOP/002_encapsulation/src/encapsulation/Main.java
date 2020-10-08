package encapsulation;
/*
 * encapsulation
 * see Product class
 * 
 * */

public class Main {

	public static void main(String[] args) {
		// create product object using new key word, fill the product instance
		// attributes using setter methods
		Product product = new Product();
		product.setId(1);
		product.setName("Laptop");
		product.setDescription("a nice one");
		product.setPrice(5678.90f);
		// if stockAmount given below 10 it show a message, because it is not fit to the
		// business logic
		product.setStockAmount(100);

		// get and print the product code using getter, other attributes getters can be
		// used same way
		System.out.println("Id: " + product.getId());
		System.out.println("Name: " + product.getName());
		System.out.println("Description: " + product.getDescription());
		System.out.println("Price: " + product.getPrice());
		System.out.println("Stock Amount: " + product.getStockAmount());
		System.out.println("Product Code: " + product.getProductCode());

	}

}
