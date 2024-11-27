package Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Base.Prematric_base;
//import Utils.Utility;

public class Personal_Info extends Prematric_base { // extend base class with this class to initialize

	// student update aadhaar

	@FindBy(xpath = "//a[contains(text(),'Pre Matric Scholarship')]") //// *[@id="details-button"]
	public WebElement stdudentcheck;

	@FindBy(xpath = "//*[@id=\"details-button\"]") //// *[@id="details-button"]
	public WebElement Studaadhaarno;

	@FindBy(xpath = "//input[@id='username' and @placeholder='Enter Username']")
	public WebElement EnteOTPButton;

	@FindBy(xpath = "//input[@id='Userpassword' and @type='password']")
	public WebElement EnterOTP;

	@FindBy(xpath = "//*[@id=\"CaptchaInputText\"]")
	public WebElement Verify_OTP;

	// parents update aadhaar

	@FindBy(xpath = "//*[@id='btnLogin' and @type='submit']")
	public WebElement parentscheck;

	@FindBy(xpath = "//*[@id='btnLogin' and @type='submit']")
	public WebElement fathercheck;

	@FindBy(xpath = "//*[@id=\"details-button\"]") //// *[@id="details-button"]
	public WebElement Parentsaadhaarno;

	@FindBy(xpath = "//input[@id='username' and @placeholder='Enter Username']")
	public WebElement Par_EnteOTPButton;

	@FindBy(xpath = "//input[@id='Userpassword' and @type='password']")
	public WebElement Par_EnterOTP;

	@FindBy(xpath = "//*[@id=\"CaptchaInputText\"]")
	public WebElement Par_Verify_OTP;

	// Instantiate
	public Personal_Info() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void select_student() {
		stdudentcheck.click();
	}

	public void Stud_Aadhaar() {
		Studaadhaarno.click();
	}

	public void enterOTPbutton(String nameuser) {
		EnteOTPButton.click();

	}

	public void EnterstudOTP(String userpassword) {
		EnterOTP.sendKeys("");
	}

	public void VerifystudOTP() throws InterruptedException {
		Verify_OTP.click();
		// captcha.click();
	}

	public void select_parentsc() {
		parentscheck.click();
	}

	public void select_Father() {
		fathercheck.click();
	}
	
	public void Father_Aadhaarno() {
		Parentsaadhaarno.click();
	}

	public void Parent_OTP_button(String nameuser) {
		Par_EnteOTPButton.click();

	}

	public void Enterpara_OTP(String userpassword) {
		Par_EnterOTP.sendKeys("");
	}

	public void VerifyfatherOTP() throws InterruptedException {
		Par_Verify_OTP.click();
		// captcha.click();
	}

	
	
	
}
