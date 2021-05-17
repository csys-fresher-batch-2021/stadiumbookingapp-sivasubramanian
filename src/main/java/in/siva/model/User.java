package in.siva.model;

public class User {

	private String userName;
	private String password;
	private String mobileNo;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public User(String userName, String password, String mobileNo) {
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
	}
}
