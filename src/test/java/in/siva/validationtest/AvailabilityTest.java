package in.siva.validationtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.siva.dao.MatchDAO;
import in.siva.exception.DbException;

public class AvailabilityTest {

	@Test
	public void test() {
		
		try {
			int a=MatchDAO.checkAvailability("2021-05-22");
			System.out.println(a);
			assertEquals(30,a);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
