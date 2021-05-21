package in.siva.converter;

import in.siva.dto.UserDTO;
import in.siva.model.User;

public class UserConverter {

	private UserConverter() {

	}

	public static User toUser(UserDTO dto) {
		String username = dto.getUserName();
		String password = dto.getPassword();
		String mobileNo = dto.getMobileNo();
		return new User(username, password, mobileNo);
	}
}
