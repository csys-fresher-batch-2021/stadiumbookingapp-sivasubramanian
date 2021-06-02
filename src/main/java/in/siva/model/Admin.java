package in.siva.model;

public class Admin {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public Admin() {
		super();
		this.username = "admin";
		this.password = "admin@123";
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
