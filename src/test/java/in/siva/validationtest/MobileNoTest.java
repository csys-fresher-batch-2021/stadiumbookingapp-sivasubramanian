package in.siva.validationtest;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.validator.UserValidator;

public class MobileNoTest {

	@Test
	public void test1() {
		assertTrue(UserValidator.isValidMobileNumber("9790174736"));
	}

	@Test
	public void test2() {
		assertFalse(UserValidator.isValidMobileNumber("97901"));
	}

	@Test
	public void test3() {
		assertFalse(UserValidator.isValidMobileNumber("9ddfkk2331"));
	}

}
