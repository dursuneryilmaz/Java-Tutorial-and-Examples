package inheritance;

public class CreditUI {
	/*
	 * the methods of this class accepts basecreditmanager object as parameter.
	 * thanks to that the childs (subclasse) of basecreditmanager class can be used as parameter
	 * this is a good example of polymorphism 
	 * 
	 * */
    public void calculateCredit(BaseCreditManager baseCreditManager){
        baseCreditManager.calculate();
    }
    
    public void getBaseAmount(BaseCreditManager baseCreditManager) {
    	baseCreditManager.getBaseCreditAmount();
	}
    
}
