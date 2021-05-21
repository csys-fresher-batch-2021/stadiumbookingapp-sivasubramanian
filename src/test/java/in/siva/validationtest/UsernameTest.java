package in.siva.validationtest;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.validator.UserValidator;

public class UsernameTest {

	@Test
	public void test1() {
		assertTrue(UserValidator.isValidUserName("siva"));
	}

	@Test
	public void test2() {
		assertFalse(UserValidator.isValidUserName("si"));
	}

	@Test
	public void test3() {
		assertFalse(UserValidator.isValidUserName(""));
	}

}
