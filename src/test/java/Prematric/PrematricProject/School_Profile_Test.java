package Prematric.PrematricProject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Prematric_base;
import Pages.Dashboard;
import Pages.School_Profile;
import Utils.ExcelReader;

public class School_Profile_Test extends Prematric_base {
	Prematric_base cc;
	School_Profile sp;

	@BeforeClass

	public void setUp() throws Exception {
		// lp = new LoginPages();
		// da = new Dashboard();
		// sp = new School_Profile();
		cc = new Prematric_base();
		initlization_logIn();
		Thread.sleep(3000);
		// lp = new TestLoginPages();
	}

	@Test
	public void filldata() throws Exception {
		sp = new School_Profile();
		sp.filldata();

		/*
		 * ExcellReader er = new ExcellReader(
		 * "C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",
		 * 1); sp.enter_pincode(er.getExcelData(1, 0));
		 */
	}

}
