package in.siva;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import in.siva.exception.DbException;
import in.siva.util.ConnectionUtil;

public class DbConnectionTest {

	@Test
	public void test() {
		try {
			Connection con=ConnectionUtil.getConnection();
			assertNotNull(con);
		} catch (DbException e) {
			e.printStackTrace();
		}
		
	}

}
