import java.util.*;

public class CheckingAccount implements HasMenu {

	protected double balance;

	public static void main(String[] args) {
		new CheckingAccount();
	}

	public CheckingAccount() {
		balance = 0;

		this.start();
	}

	public CheckingAccount(double balance) {
		this.balance = balance;
	}

	public String menu() {
		String menu_text = "\nAccount Menu";
		menu_text += "\n\n";
		menu_text += "0) quit\n";
		menu_text += "1) check balance\n";
		menu_text += "2) make a deposit\n";
		menu_text += "3) make a withdrawal\n\n";

		return menu_text;
	}

	public void start() {
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println(menu());
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter 0-3: ");
			String selection = scanner.nextLine();

			if(selection.equals("0"))
				keepGoing = false;
			else if(selection.equals("1"))
				checkBalance();
			else if(selection.equals("2"))
				makeDeposit();
			else if(selection.equals("3"))
				makeWithdrawal();
			else
				System.out.println("Invalid input. Try again..");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void checkBalance() {
		String balance_text = "\nChecking Balance...\n";
		balance_text += "Current balance: $" + balance;

		System.out.println(balance_text);
	}

	public double getDouble() {
		return balance;
	}

	public void makeDeposit() {
		System.out.println("\nMaking a deposit...");
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("How much to deposit? ");
		double deposit = scanner.nextDouble();
		setBalance(getBalance() + deposit);
		System.out.println("\nNew balance: " + getBalance());
	}

	public void makeWithdrawal() {
		System.out.println("\nMaking a withdraw...");

		Scanner scanner = new Scanner(System.in);
		System.out.print("How much to withdraw? ");
		double withdrawal = scanner.nextDouble();
		setBalance(getBalance() - withdrawal);
		System.out.println("\nNew balance: " + getBalance());
	}
}
