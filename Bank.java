import java.util.*;

public class Bank implements HasMenu {

	public static void main(String[] args){
		new Bank();
	}

	Map<String, Customer> customers;

	public Bank() {
		loadSampleCustomers();
		start();
	}

	void loadSampleCustomers() {
		customers = new HashMap<String, Customer>();

		customers.put("test1", new Customer("test1", "1234"));
		customers.put("test2", new Customer("test2", "4321"));
	}

	void saveCustomers() {

	}

	void loadCustomers() {
		//customers = new ArrayList<Customer>();
	}

	void reportAllUsers() {

	}

	void addUser() {

	}

	void loginAsCustomer() {
		boolean keepGoing = true;
		Customer loaded = null;
		while(keepGoing) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("user name: ");
			String username_input = scanner.nextLine();

			System.out.print("PIN: ");
			String PIN_input = scanner.nextLine();
			
			loaded = customers.get(username_input);
			if (loaded != null && loaded.getPIN().equals(PIN_input))
				keepGoing = false;
			else
				System.out.println("Invalid Customer. Try again..");
		}

		System.out.println("Login Successful!");
		loaded.start();
	}

	public String menu() {
		String menu_text = "";
		
		return menu_text;	
	}

	public void start() {
		loginAsCustomer();
	}

	void startAdmin() {

	}
}
