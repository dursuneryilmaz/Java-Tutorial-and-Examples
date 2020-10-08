package inheritance;
/*
 * inheritance 
 * In Java, it is possible to inherit attributes and methods from one class to another. 
 * We group the "inheritance concept" into two categories:
 *    subclass (child) - the class that inherits from another class
 *    superclass (parent) - the class being inherited from
 * To inherit from a class, use the extends keyword.
 * 
 * a bank credit calculation system demonstared to understand inheritance.
 * in this example the is a base credit manager and all other credit managers extends it.
 * 
 * */

public class Main {
    public static void main(String[] args) {
    	SoldierCreditManager soldierCreditManager =  new SoldierCreditManager();
    			
        CreditUI creditUI=new CreditUI();
        // below functions accepts an instance of BaseCreditManager, soldierCreditManager is also BaseCreditManager instance
        // so it can be used
        // the other child classes of BaseCreditManager class can be used. it is polymorphism
        creditUI.calculateCredit(soldierCreditManager);
        creditUI.getBaseAmount(soldierCreditManager);
    }
}
