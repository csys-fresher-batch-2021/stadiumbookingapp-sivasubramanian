package in.siva;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.service.UserManager;

public class UserLoginTest {

	/**
	 * Test with registered data.
	 */
	@Test
	public void testWithRegisteredData() {
		try {
			boolean valid = UserManager.login("siva", "Siva@123456");
			assertTrue(valid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test with not registered data.
	 */
	@Test
	public void testWithNotRegisteredData() {

		try {
			UserManager.login("sankar", "Sankar@2123");
		} catch (Exception e) {
			assertEquals("Not Registered", e.getMessage());
		}
	}

	/**
	 * Test with invalid data.
	 */
	@Test
	public void testWithInvalidUserLogin() {

		try {
			UserManager.login("  ", "Sankar@123");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Unable to login", e.getMessage());
		}
	}
}
