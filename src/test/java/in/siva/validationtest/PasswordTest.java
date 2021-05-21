package in.siva.validationtest;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.validator.UserValidator;

public class PasswordTest {

	@Test
	public void test1() {
		assertTrue(UserValidator.isValidPassword("Siva@12345"));
	}

	@Test
	public void test2() {
		assertFalse(UserValidator.isValidPassword("siva@1234"));
	}

	@Test
	public void test3() {
		assertFalse(UserValidator.isValidPassword("siva12345"));
	}

}
