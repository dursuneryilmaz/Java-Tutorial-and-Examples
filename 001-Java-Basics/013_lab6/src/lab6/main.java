package lab6;

import java.util.Scanner;
/*
 * lab6
 * Demonstrate a ATM machine using arrays
 * 
 */
public class main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int[] account = new int[10];
		for (int i = 1; i < 10; i++) {
			account[i] = 100;
		}

		ChekPoint(account);
	}

	public static void ChekPoint(int account[]) {
		int chek = 0;
		System.out.print("Enter an id:");

		do {

			chek = input.nextInt();
			if (chek < 10 && chek > 0) {
				Menu(account, chek);
				break;
			} else {
				System.out.print("Enter an valid id:");
			}
		} while (chek < 10 || chek > 0);
	}

	public static void Menu(int account[], int acc) {

		int choise;
		System.out.print("\nMain menu\n 1:check balance\n 2:withdraw\n 3:deposit\n 4:exit\nEnter a choise:");
		choise = input.nextInt();
		while (1 < 11) {
			switch (choise) {
			case 1:
				checkBalance(account, acc);
				break;
			case 2:
				withDraw(account, acc);
				break;
			case 3:
				Deposit(account, acc);
				break;
			case 4:
				System.out.println("---------------------");
				ChekPoint(account);
				break;
			default:
				System.out.print("Make an exist choise:");
				choise = input.nextInt();
				break;
			}

		}
	}

	static void checkBalance(int balance[], int acc) {
		System.out.println("The Balance is:" + balance[acc]);
		Menu(balance, acc);

	}

	static void withDraw(int account[], int acc) {
		Scanner input = new Scanner(System.in);
		int money;
		System.out.print("Enter an amount to withdraw:");
		money = input.nextInt();
		account[acc] -= money;

		Menu(account, acc);
		input.close();
	}

	static void Deposit(int account[], int acc) {
		Scanner input = new Scanner(System.in);
		int money;
		System.out.print("Enter an amount to deposit:");
		money = input.nextInt();
		account[acc] += money;

		Menu(account, acc);
		input.close();
	}
}
