package statics;

public class ProductValidator {
	// static constructor syntax
    static {
        System.out.println("Static Constructor has worked.");
    }
    
    public ProductValidator(){
        System.out.println("Non static Constructor worked.");
    }
    
    // product price bigger than 10 and name is not emty
    public static boolean isValid(Product product){
        if(product.price>0 && !product.name.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}