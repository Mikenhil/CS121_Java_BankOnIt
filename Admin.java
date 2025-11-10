import java.util.*;

public class Admin extends User {

	public Admin() {

	}

	public Admin(String userName, String PIN) {
		this.userName = userName;
		this.PIN = PIN;
	}

	public String menu() {
		String menu_text = "\nAdmin Menu\n\n";
		menu_text += "0) Exit this menu\n";
		menu_text += "1) Full customer report\n";
		menu_text += "2) Add User\n";
		menu_text += "3) Apply interest to savings accounts\n";

		return menu_text;
	}

	public String getReport() {
		return "";
	}
}
