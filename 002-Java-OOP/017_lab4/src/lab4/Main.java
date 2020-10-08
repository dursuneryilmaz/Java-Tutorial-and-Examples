package lab4;

import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Please enter the number of customers:");
		int n = input.nextInt();

		Account[] account = new Account[n];
		for (int i = 0; i < n; i++) {
			account[i] = new Account();
			account[i].setId(1000 + i);
			Account.setAnnualInterestRate(4.5);
		}
		System.out.print("Please enter the " + n + " new balance:");
		for (int i = 0; i < n; i++) {
			account[i].setBalance(input.nextInt());
			account[i].deposit(3000);
			account[i].withdraw(2500);
		}

		for (int i = 0; i < n; i++) {
			System.out.println("");
			System.out.println("Balance is: " + account[i].getBalance());
			System.out.println("Monthly interest is: " + account[i].getMonthlyInterest());
			System.out.println(
					"This account was created at  " + account[i].getDateCreated() + " with ID " + account[i].getId());
			System.out.println("");
		}
	}

}
