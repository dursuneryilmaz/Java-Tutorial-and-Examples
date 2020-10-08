package statics;

public class ProductManager {
	
    public void  add(Product product){
        if(ProductValidator.isValid(product)){
            System.out.println("Product Added.");
        }else{
            System.out.println("Product is not valid!!");
        }
    }
    
}
