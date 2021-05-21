package in.siva;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.dto.UserDTO;
import in.siva.service.UserManager;

public class UserRegisterTest {

	@Test
	public void test() {
		try {
			UserDTO dto = new UserDTO("vel", "Vel@12345", "7878988866");
			boolean valid = UserManager.register(dto);
			assertTrue(valid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test1() {

		try {
			UserDTO dto = new UserDTO("", "vel12345", "7878988866");
			boolean valid = UserManager.register(dto);
			assertFalse(valid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
