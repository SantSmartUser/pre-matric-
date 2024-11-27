package Prematric.PrematricProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Prematric_base;

public class TestLoginPages extends Prematric_base {

	// LoginPages lh; // Created object for other class "LoginHomePage"
	TestLoginPages lp; // Created object for current class "LoginPage"

	@BeforeMethod

	public void setUp() throws Exception {

		initlization_logIn();
		Thread.sleep(3000);
		lp = new TestLoginPages();

	}

	@Test

	public void Home_Page() throws Exception { // created one method for call initialization and login

		// lh.wrdaccept();
	}

	@AfterMethod

	public void tearDown() {

		driver.close();

	}

}
