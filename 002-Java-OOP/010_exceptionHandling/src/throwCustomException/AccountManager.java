package throwCustomException;

public class AccountManager {
    private double balance;

    public void deposit(double amount){
        balance = getBalance() + amount;
    }

    public void  withdraw(double amount) throws BalanceInsufficentException {
        if(balance>=amount){
            balance = getBalance() - amount;
        }else{
            throw new BalanceInsufficentException("Insufficient Balance");
        }

    }

    public double getBalance() {
        return balance;
    }
}
