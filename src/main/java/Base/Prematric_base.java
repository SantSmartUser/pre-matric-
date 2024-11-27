package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Dashboard;
//import Pages_Bill_Irrigation_S1.LoginHomePage;
import Pages.LoginPages;
import Pages.School_Profile;
import Pages.Student_Profile;


public class Prematric_base {

	public static WebDriver driver; // Make Static
	public static Properties props; // Make static and created object for properties as a props

	LoginPages lp;
	Dashboard da;
	School_Profile sp;
	Student_Profile sp1;

	public Prematric_base() {
		try {
			props = new Properties(); // FileInput Stream used to read data from confiq file
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\Config\\config.properties");
			props.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initlization() { // to Initialize the Browser

		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("URL"));
		// return driver;

	}

	public void initlization_logIn() throws Exception { // Initialize login page

		initlization();

		lp = new LoginPages();
		da = new Dashboard();
		sp = new School_Profile();
		sp1 = new Student_Profile();
		// Created object for Login Page
		// lp.language_details(); // added new line
	//	lp.Login_tab();
		lp.Login1_tab();
		lp.enterUsername(props.getProperty("Username")); // get user name and pass from config Properties with get // Properties
		lp.enterPassword(props.getProperty("Password"));
		Thread.sleep(9000);
		//lp.enter_captcha();
		// Need to add Thread Sleep for captcha
		// lp.district();
		//lp.click_Captch();
		
		lp.clickLoginButton();
		da.click_ON_Dahboard();
		da.Total_students();
		da.Back_Button();
		sp.click_School_profile();

	}

	public WebDriver Approval_initlization_logIn() throws InterruptedException { // This is initilize for Approval
																					// Window after 1st part

		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(props.getProperty("Approval_URL"));
		return driver;
	}
	/*
	 * public String takeScreenshot(String testName, WebDriver driver) {
	 * 
	 * File sourceScreenshots = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * String destinationScreenshotpath = System.getProperty("user.dir") +
	 * "\\Screenshots\\" + testName + ".png";
	 * 
	 * try {
	 * 
	 * .copyFile(sourceScreenshots, new File(destinationScreenshotpath));
	 * 
	 * } catch (IOException e) {
	 * 
	 * // TODO Auto-generated catch block
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * return destinationScreenshotpath;
	 * 
	 * }
	 * 
	 * 
	 */

}
