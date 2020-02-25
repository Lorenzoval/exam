package logic;

import java.util.Random;

public class LoginController {

	Random rand = new Random();
	
	public void login(String username, String password) throws Exception {
		/*
		 * this method tries to log the user in, if it is successful
		 * it checks for network congestion and makes the user wait for
		 * a time proportioned to his position in login queue, before
		 * allowing him to access the site
		 */
		this.authenticate(username, password);

		if (this.congestion()) {
			long toWait = this.toWait();
			try {
				Thread.sleep(toWait);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.loadSession(username, password);

	}
	
	public void authenticate(String username, String password) throws Exception {
		if (username.equals("username") && password.equals("password"))
			return;
		else
			throw new Exception();
	}
	
	public boolean congestion() {
		// aleatory event in practice, thus its coverage is impossible
		int coinFlip = rand.nextInt(10);
		return (coinFlip < 3);
	}
	
	public void loadSession(String username, String password) {
		// stub
	}
	
	public long toWait() {
		// stub, should check login queue
		return 3000;
	}

}
