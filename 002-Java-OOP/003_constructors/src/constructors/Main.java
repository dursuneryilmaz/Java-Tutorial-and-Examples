package constructors;
/*
 * constructors
 * do not forget to see Product class
 * no need to filling each attribute to understand constructors
 * 
 * */

public class Main {

	public static void main(String[] args) {
		// create product object using new key word and default constructor
		// default/unassigned integer value is 0
		Product product = new Product();
		System.out.println("Default Constructor Product Id: "+product.getId()+"\n");
		
		
		// create product object using new key word and custom constructor		
		Product product2 = new Product(109);
		System.out.println("Custom Constructor Product Id:"+product2.getId());
		

	}

}
