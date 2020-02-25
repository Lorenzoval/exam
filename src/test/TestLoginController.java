package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.LoginController;

public class TestLoginController {
	
	@Test
	public void testValidLogin() throws Exception {
		
		LoginController lc = new LoginController();
		lc.login("username", "password");
		
	}
	
	@Test(expected = Exception.class)
	public void testInvalidLogin() throws Exception {
		
		LoginController lc = new LoginController();
		lc.login("password", "username");

	}
	
	@Test
	public void testLoadSession() {
		// stub
		LoginController lc = new LoginController();
		lc.loadSession("username", "password");
	}
	
	@Test
	public void testToWait() {
		// stub, depends on queue position
		LoginController lc = new LoginController();
		long toWait = lc.toWait();
		assertEquals(3000, toWait);
	}

}
