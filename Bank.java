import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

	public static void main(String[] args){
		new Bank();
	}

	String filePath = "customerData.dat";

	Admin admin;
	List<Customer> customers;

	public Bank() {
		admin = new Admin("admin", "0000");
		
		// Uncomment to refresh data
		//loadSampleCustomers();
		//saveCustomers();

		loadCustomers();
		start();
		saveCustomers();
	}

	void loadSampleCustomers() {
		customers = new ArrayList<Customer>();

		customers.add(new Customer("John", "1234"));
		customers.add(new Customer("Doe", "0000"));
	}

	void loadCustomers() {
		try {
			FileInputStream file = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(file);

			customers = (List<Customer>) in.readObject();

			file.close();
			in.close();

			System.out.println("Loaded customers..");
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("Issue with loading...");
		}
	}

	void saveCustomers() {
		try {
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(customers);
			out.close();
			file.close();

			System.out.println("Customers saved..");
		}
		catch(IOException e) {
			System.out.println("Issue with saving...");
		}
	}

	void reportAllUsers() {
		for(Customer customer : customers) {
			System.out.println(customer.getReport());
		}
	}

	void addUser() {
		System.out.println("Add a user\n");

		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing) {
			
			System.out.print("New username: ");
			String new_username = scanner.nextLine();

			System.out.print("New PIN: ");
			String new_PIN = scanner.nextLine();

			System.out.print("Confirm PIN:");
			String conf_PIN = scanner. nextLine();

			if(new_PIN.equals(conf_PIN)) {
				customers.add(new Customer(new_username, new_PIN));
				keepGoing = false;
			}
			else {
				System.out.println("PIN does not match. Try again..");
			}
		}
	}

	void loginAsCustomer() {
		System.out.println("Customer login");
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.print("username: ");
			String username_input = scanner.nextLine();

			System.out.print("PIN: ");
			String PIN_input = scanner.nextLine();
			
			for(Customer customer : customers) {
				if(customer.login(username_input, PIN_input)) {
					System.out.println("Login Successful!");

					keepGoing = false;
					customer.start();
					break;
				}

			}
		}
	}

	public String menu() {
		String menu_text = "\nBank Menu\n\n";
		menu_text += "0) Exit system\n";
		menu_text += "1) Login as admin\n";
		menu_text += "2) Login as customer\n";	
		
		return menu_text;	
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println(menu());

			System.out.print("Action: ");
			String input = scanner.nextLine();

			if(input.equals("0")) {
				keepGoing = false;
			}
			else if(input.equals("1")) {
				loginAsAdmin();
			}
			else if(input.equals("2")) {
				loginAsCustomer();
			}
			else {
				System.out.println("Invalid input. Try again..");
			}
		}
	}

	void loginAsAdmin() {
		System.out.println("Admin login");
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.print("username: ");
			String username_input = scanner.nextLine();

			System.out.print("PIN: ");
			String PIN_input = scanner.nextLine();

			if(admin.login(username_input, PIN_input)) {
				System.out.println("Login Successful!");

				startAdmin();
			}
			keepGoing = false;
		}
	}

	void startAdmin() {
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println(admin.menu());

			System.out.print("Action: ");
			String input = scanner.nextLine();

			if(input.equals("0")) {
				keepGoing = false;
			}
			else if(input.equals("1")) {
				reportAllUsers();
			}
			else if(input.equals("2")) {
				addUser();
			}
			else if(input.equals("3")) {
		
			}
			else {
				System.out.println("Invalid input. Try again..");
			}
		}
	}
}
