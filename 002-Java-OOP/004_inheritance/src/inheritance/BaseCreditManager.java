package inheritance;

public class BaseCreditManager {
	float baseCreditAmount = 10000;
	
    public void  calculate(){
        System.out.println("Credit Calculated!");
    }
    
    public void getBaseCreditAmount() {
    	System.out.println("Base Amount: "+this.baseCreditAmount);
	}
}
