package classes;

/* 
 * a class like Main class and contains some functions/methods
 * demonstrate a ProductManager class in simple terms
 * action / method class which is a collection of methods there can be any other variable which this class does not related work 
 * 
 * 
 * */
public class ProductManager {

	
	public void Create(Product product) {
		System.out.println("Product Created Id= "+ product.id);
	}
	
	public void Read(Product product) {
		System.out.println("Product Read Id= "+product.id);
	}

	public void Update(Product product) {
		System.out.println("Product Updated Id= "+product.id);

	}

	public void Delete(Product product) {
		System.out.println("Product Deleted Id= "+ product.id);

	}

}
