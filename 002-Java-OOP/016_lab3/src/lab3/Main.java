
package lab3;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Account Acc = new Account();
		Acc.setId(1122);
		Acc.setBalance(20000);
		Acc.setAnnualInterestRate(4.5);

		Acc.setBalance(withdraw(Acc.getBalance(), 2500));
		Acc.setBalance(deposit(Acc.getBalance(), 3000));
		Acc.setAnnualInterestRate(getMonthlyInterest(Acc.getBalance(), Acc.getAnnualInterestRate()));

		System.out.println("Balance is: " + Acc.getBalance());
		System.out.println("Monthly interest is: " + Acc.getAnnualInterestRate());
		System.out.println("This account was created at  " + Acc.getCreatedDate());
	}

	static double withdraw(double balance, double money) {
		balance -= money;
		return balance;
	}

	static double deposit(double balance, double money) {
		balance += money;
		return balance;
	}

	static double getMonthlyInterest(double balance, double rate) {
		double intrest = (balance * rate / 100) / 12;
		return intrest;
	}

	void getMonthlyInterestRate() {

	}
}
// inner class
class Account {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	private int id;
	private double balance;
	private double annualInterestRate;
	private Date createdDate = new Date();

}