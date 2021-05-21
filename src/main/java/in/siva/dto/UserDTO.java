package in.siva.dto;

public class UserDTO {

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

	public UserDTO(String userName, String password, String mobileNo) {
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
	}

}
