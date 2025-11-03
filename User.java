import java.util.*;

public abstract User implements HasMenu {
	
	protected String userName;
	protected String PIN;
	
	public User() {

	}

	public boolean login() {
		return false;
	}

	public boolean login(String userName, String PIN) {
		return false;
	}

	public void setUserName(String UserName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPIN() {
		this.PIN = PIN;
	}

	public String getPIN() {
		return PIN;
	}

	String menu() {
		return "";
	}

	void start() {

	}

	public abstract String getReport();
}
