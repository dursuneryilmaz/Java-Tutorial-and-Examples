package throwCustomException;
/*
 * java many exception but if you want to create new one in depends on your problem domain
 * it can be done like this class 
 * all exception types inherits from the super class Exception 
 * 
 * it can be customized using method overriding
 * */

public class BalanceInsufficentException extends Exception {
    String message;
    public BalanceInsufficentException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
