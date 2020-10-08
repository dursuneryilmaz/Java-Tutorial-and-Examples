
package lab4;

public class Account {

	private int id;
	private double balance;
	private static double annualInterestRate;
	private java.util.Date dateCreated;

	public Account() {
		dateCreated = new java.util.Date();
	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		dateCreated = new java.util.Date();
	}

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

	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		Account.annualInterestRate = annualInterestRate;
	}

	public void setDateCreated(java.util.Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getMonthlyInterest() {
		return balance * (annualInterestRate / 1200);
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public double withdraw(double amount) {
		this.balance -= amount;
		return balance;
	}

	public double deposit(double amount) {
		this.balance += amount;
		return balance;
	}

}
