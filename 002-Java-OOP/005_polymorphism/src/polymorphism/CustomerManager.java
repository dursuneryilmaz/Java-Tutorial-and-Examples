package polymorphism;

public class CustomerManager {
    private  BaseLogger logger;
    
    // constructor
    public CustomerManager(BaseLogger logger){
        this.logger = logger;
    }
    
    public void  add(){
        System.out.print("Customer Added -> ");
        this.logger.log("Successfull");
    }
}
