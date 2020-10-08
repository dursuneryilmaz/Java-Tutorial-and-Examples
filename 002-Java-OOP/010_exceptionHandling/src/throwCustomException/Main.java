package throwCustomException;
/*
 * Exceptions can be customized see BalanceInsufficentException
 * Account manager example 
 * Exception may not be handled in same class. That class or method can throw that exception using "throw" key word in it's signature. 
 * 
 * */
public class Main {

    public static void main(String[] args) {
	    AccountManager manager=new AccountManager();
	    System.out.println("Balance = "+manager.getBalance());
	    manager.deposit(100);
	    System.out.println("Deposit Completed!");
        System.out.println("Balance  = "+manager.getBalance());
        try{
            manager.withdraw(90);
            System.out.println("Withdraw Completed!");
        }catch (BalanceInsufficentException exception){
           System.out.println(exception.getMessage());
           System.out.println("Withdraw Failed!!");
        }

        System.out.println("Balance = "+manager.getBalance());
        try{
            manager.withdraw(90);
        }catch (BalanceInsufficentException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("Balance = "+manager.getBalance());
    }
    
    
    public static void exceptionThrowMethod() throws Exception {
    	// if a method throws a particular exceptions there is no need to use try carch blocks for it
    }
}
