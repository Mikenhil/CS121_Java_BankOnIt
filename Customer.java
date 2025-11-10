import java.util.*;

public class Customer extends User {

	public static void main(String[] args) {

	}

	CheckingAccount checking;
	SavingsAccount savings;

	public Customer() {
	
	}

	public Customer(String userName, String PIN) {
		this.userName = userName;
		this.PIN = PIN;

		checking = new CheckingAccount(500);
		savings = new SavingsAccount(500);
	}	
	
	public String menu() {
		String menu_text = "\nCustomer Menu\n\n";
		menu_text += "0) Exit\n";
		menu_text += "1) Manage Checking Account\n";
		menu_text += "2) Manage Savings Account\n";
		menu_text += "3) Change PIN\n\n";

		return menu_text;	
	}

	public void start() {
		boolean keepGoing = true;
		while(keepGoing) {
			Scanner scanner = new Scanner(System.in);

			System.out.println(menu());

			System.out.print("Action (0-3): ");
			String response = scanner.nextLine();

			if(response.equals("0"))
			       keepGoing = false;
			else if(response.equals("1"))
				checking.start();
			else if(response.equals("2"))
				savings.start();
			else if(response.equals("3"))
				changePIN();
			else
				System.out.println("Invalid input. Try again..");	
		}
	}

	void changePIN() {
		boolean keepGoing = true;
		while(keepGoing) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter a new PIN: ");
			String newPIN = scanner.nextLine();

			this.setPIN(newPIN);
			System.out.println("New PIN saved!");
		}
	}

	@Override
	public String getReport() {
		String report_text = "User: " + this.userName 
			+ ", Checking: " + checking.getBalance()
			+ ", Savings: $" + savings.getBalance();

		return report_text;
	}
}
