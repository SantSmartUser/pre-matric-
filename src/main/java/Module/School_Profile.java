package Module;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Prematric_base;
import Utils.Utility;
import Utils.ExcelReader;

public class School_Profile extends Prematric_base { // extend base class with this class to initialize

	@FindBy(xpath = "//a[@href='/Pre_SchoolInfo/SchoolInfo']")
	private WebElement School_profile;

	@FindBy(xpath = "//input[@name='Submit']") //// *[@id="details-button"] //input[@id='btnSaveFinal']
	public WebElement Submit;

	@FindBy(xpath = "//button[@id='btnClear']") //// *[@id="details-button"]
	public WebElement Back;

	@FindBy(xpath = "//*[@id='VillageID']")
	private WebElement village;

	@FindBy(xpath = "//input[@id='PinCode']")
	private WebElement pincode;

	@FindBy(xpath = "//input[@id='SchoolEmailId']")
	private WebElement School_Email_Id;

	@FindBy(xpath = "//input[@id='SchoolContactNo']")
	private WebElement School_Contact_No;

	@FindBy(xpath = "//input[@id='SchoolWebsite']")
	private WebElement Schoo_Website;

	@FindBy(xpath = "//input[@id='SchoolRegistrationNo']")
	private WebElement School_Registration_No;

	@FindBy(xpath = "//input[@id='SchoolEstablishmentYear']")
	private WebElement Establishment_Year;

	@FindBy(xpath = "/html/body/div[4]/div[1]/table/thead/tr[2]/th[2]']")
	private WebElement yearselect;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthselect;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> dateselect;

	@FindBy(xpath = "//*[@id=\"SchoolBoardId\"]")
	private WebElement SchoolBoard;

	@FindBy(xpath = "//*[@id=\"SchoolRegionCode\"]")
	private WebElement IsSchoolUnder;

	@FindBy(xpath = "//*[@id=\"IsITI\"and @value='1'  ]") ////
	private WebElement ITI;

	@FindBy(xpath = "//input[@id='PrincipalName']") ////
	private WebElement Full_Name;

	@FindBy(xpath = "//*[@id=\"PrincipalMobileNo\"]") ////
	private WebElement Mobile_namber;

	@FindBy(xpath = "//*[@id='btnGetOTP_Mobile']") //// i
	private WebElement Get_OTP_MobNum;

	@FindBy(xpath = "//*[@id='temp_MobileOTP']") ////
	private WebElement EnerOTPMobile;

	@FindBy(xpath = "//*[@id='btnVerifyOTP_Mobile']")
	private WebElement VerifyOTPMobile;

	@FindBy(xpath = "//*[@id='PrincipalEmail']")
	private WebElement P_Email_ID;

	@FindBy(xpath = "//button[@id='btnGetOTP_Email']") //// *[@id="btnGetOTP_Email"]
	private WebElement Get_Email_otp;

	@FindBy(xpath = "//input[@id='temp_EmailOTP' and @name='temp_EmailOTP']") //// *[@id="temp_EmailOTP"]
																				//// //btnGetOTP_Email
	private WebElement Enter_Email_otp;

	@FindBy(xpath = "//button[@id='btnVerifyOTP_Email'and not(@disabled)]") /// html/body/div[1]/div[2]/section/div[1]/div[2]/section/div[5]/div/form/fieldset[2]/div[8]/div[2]/div[3]/div/button
	private WebElement VerifyOTPGmail;

	@FindBy(xpath = "//*[@id=\"ClerkName\"]")
	private WebElement C_Full_Name;

	@FindBy(xpath = "//*[@id=\"ClerkMobileNo\"]")
	private WebElement c_Mob_No;

	@FindBy(xpath = "//*[@id=\"btnGetOTP_Mobile_Clerk\"]") // button[@id='btnVerifyOTP_Mobile_Clerk']
	private WebElement Get_OTP_CMobNum;

	@FindBy(xpath = "//*[@id=\"temp_MobileOTP_Clerk\"]")
	private WebElement enterOTPCMobile;

	@FindBy(xpath = "//button[@id='btnVerifyOTP_Mobile_Clerk']")
	private WebElement VerifyOTPCMobile;

	@FindBy(xpath = "//input[@id='ClerkEmail']")
	private WebElement C_Email_ID;

	@FindBy(xpath = "//button[@id=\"btnGetOTP_Email_Clerk\"]") //// *[@id="btnGetOTP_Email"]
	private WebElement Get_C_Email_otp;

	@FindBy(xpath = "//input[@id=\"temp_EmailOTP_Clerk\"]") //// *[@id="temp_EmailOTP"] //btnGetOTP_Email
	private WebElement Enter_CEmail_otp;

	@FindBy(xpath = "//button[@id=\"btnVerifyOTP_Email_Clerk\"]")
	private WebElement VerifyOTPCGmail;

	@FindBy(xpath = "//*[@id=\"BankAccountNo\"]") //// *[@id="BankAccountNo"]
	private WebElement bankAccount;

	@FindBy(xpath = "//*[@id=\"btnGetOTP_MobileBank\"]") //// *[@id="btnGetOTP_MobileBank"]
	private WebElement getprincipalno;

	@FindBy(xpath = "//*[@id=\"temp_MobileOTPBank\"]")
	private WebElement EnterAccountotp;

	@FindBy(xpath = "//*[@id=\"btnVerifyOTP_MobileBank\"]")
	private WebElement VerifyOTPBankaccount;

	@FindBy(xpath = "//*[@id=\"AccountHolder\"]")
	private WebElement Accountholdername;

	@FindBy(xpath = "//*[@id=\"IFSCCode\"]")
	private WebElement IFSC;

	@FindBy(xpath = "//*[@id=\"file1\" and @name='file1']") //// *[@id="file1"]
	private WebElement Bank_Doc;

	@FindBy(xpath = "//*[@id=\"docs1View\"]/a")
	private WebElement ViewDocument;

	@FindBy(xpath = "//input[@id='btnSaveFinal']")
	private WebElement SaveButton;

	// Instantiate
	public School_Profile() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void Village() {
		WebElement VL = village;
		Utility.selectOptionFromDropDown(VL, "CHIKHLI (N.P.)");

	}

	public void enter_pincode(String pin) {
		// pincode.clear();
		pincode.sendKeys(pin);
	}

	public void enter_School_Email_Id(String schoolEmail) {
		// School_Email_Id.clear();
		School_Email_Id.sendKeys(schoolEmail);
	}

	public void enter_School_Contact_No(String schoolcontactno) {
		// School_Contact_No.clear();
		School_Contact_No.sendKeys(schoolcontactno);
	}

	public void enter_Schoo_Website(String schoolwebsite) {
		// Schoo_Website.clear();
		Schoo_Website.sendKeys(schoolwebsite);
	}

	public void enter_School_Registration_No(String schoolRegistraionno) {

		// School_Registration_No.clear();
		School_Registration_No.sendKeys(schoolRegistraionno);
	}

	public void EstablishmentYear() {
		Establishment_Year.click();

	}

//	public void yearselection() {
//
//		Select s2 = new Select(yearselect);
//		s2.selectByVisibleText("1997");
//
//	}
//
//	public void monthselect() {
//
//		Select s1 = new Select(monthselect);
//		s1.selectByVisibleText("Feb");
//
//	}
//
//	public void dateofb() {
//		String date = "17";
//		for (WebElement ele : dateselect) {
//			String dt = ele.getText();
//			if (dt.equals(date)) {
//				ele.click();
//				break;
//			}
//			System.out.println("Date Selected");
//		}
//	}

	public void School_Board() {
		WebElement SB = SchoolBoard;
		Utility.selectOptionFromDropDown(SB, "Other");

	}

	public void Is_School_Under() {
		WebElement ISU = IsSchoolUnder;
		Utility.selectOptionFromDropDown(ISU, "PMRDA");

	}

	public void IsITI() {
		ITI.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");

	}

	public void P_Full_Name(String FullName) {
		// School_Registration_No.clear();
		Full_Name.sendKeys(FullName);
	}

	public void MobileNumber(String Mobileno) {
		// School_Registration_No.clear();
		Mobile_namber.sendKeys(Mobileno);
		Mobile_namber.sendKeys(Keys.ENTER);

	}

	public void Get_OTP_MobNum() throws InterruptedException {
		// School_Registration_No.clear();

		Get_OTP_MobNum.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(9000);

	}

	public void EnterOTP() throws InterruptedException {
		// EnerOTPMobile.click();
		EnerOTPMobile.sendKeys("");
		Thread.sleep(7000);
	}

	public void Verify_OTP_Mobile() throws InterruptedException {
		Thread.sleep(5000);
		VerifyOTPMobile.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();

	}

	public void p_Email_ID(String EmailID) {
		// School_Registration_No.clear();
		P_Email_ID.sendKeys(EmailID);
		P_Email_ID.sendKeys(Keys.ENTER);

	}

	public void Get_Email_OTP() throws InterruptedException {
		Get_Email_otp.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
	}

	public void EnterEmailOTP() throws InterruptedException {
		Enter_Email_otp.sendKeys("");
		Thread.sleep(7000);

	}

	public void Verify_OTP_Gmail() throws InterruptedException {
		Thread.sleep(12000);
		VerifyOTPGmail.click();
		// VerifyOTPGmail.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();

	}

	public void C_Full_EnterName(String CFullName) {
		// School_Registration_No.clear();
		C_Full_Name.sendKeys(CFullName);
	}

	public void C_EnterMobileNumber(String CMobileno) {
		c_Mob_No.sendKeys(CMobileno);
		c_Mob_No.sendKeys(Keys.ENTER);

	}

	public void C_GETMobilenumberOTP() throws InterruptedException {
		// School_Registration_No.clear();
		Get_OTP_CMobNum.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(9000);
	}

	public void C_EnterMobileOTP() throws InterruptedException {
		// School_Registration_No.clear();
		enterOTPCMobile.sendKeys("");
		Thread.sleep(6000);
	}

	public void Verify_OTP_CMobile() throws InterruptedException {
		Thread.sleep(9000);
		VerifyOTPCMobile.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
	}

	public void C_EnterEmail_ID(String EmailID) {
		// School_Registration_No.clear();
		C_Email_ID.sendKeys(EmailID);
		C_Email_ID.sendKeys(Keys.ENTER);

	}

	public void Get_CEmail_OTP() throws InterruptedException {

		Get_C_Email_otp.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
	}

	public void EnterCEmailOTP() throws InterruptedException {
		Enter_CEmail_otp.sendKeys("");
		Thread.sleep(8000);

	}

	public void Verify_OTP_CGmail() throws InterruptedException {
		Thread.sleep(14000);
		VerifyOTPCGmail.click();
		// VerifyOTPGmail.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();

	}

	public void EnterBank_Account_No(String bankacount) {
		bankAccount.sendKeys(bankacount);
		bankAccount.sendKeys(Keys.ENTER);

	}

	public void GetOTPPrincipalMobileNumber() throws InterruptedException {
		Thread.sleep(2000);
		getprincipalno.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();

	}

	public void EnteraccontnoOTP() throws InterruptedException {
		EnterAccountotp.sendKeys("");
		Thread.sleep(8000);
	}

	public void VerifyAccountHolderOTP() throws InterruptedException {
		Thread.sleep(14000);
		VerifyOTPBankaccount.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
	}

	public void EnterAccountHolderName(String accountholder) {
		Accountholdername.sendKeys(accountholder);

	}

	public void EnterIFSCCode(String ifsc) {
		IFSC.sendKeys(ifsc);
		IFSC.sendKeys(Keys.ENTER);
	}

	public void Upload_document() throws InterruptedException {

		// Bank_Doc.click();
		Bank_Doc.sendKeys("C:\\Users\\Santosh.Satpute\\Desktop\\Bank Document.pdf");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public void View_Document() throws InterruptedException { // *[@id="docs1View"]
		Thread.sleep(5000);
		ViewDocument.click();
		Set<String> list1 = driver.getWindowHandles();
		Iterator<String> it = list1.iterator();
		String Schoolprofile = it.next();
		String ViewDocumentWindow = it.next();

		driver.switchTo().window(Schoolprofile);
	
	
//		 driver.switchTo().window(newTab.get(0));
//		    assertAdvertisingBlog();
//
//		    // Do what you want here, you are in the new tab
//
//		    driver.close();
//		    // change focus back to old tab
//		    driver.switchTo().window(oldTab);
//		    assertStartAdvertising();
//			
	}

	public void Saveschoolprofile() throws InterruptedException { // *[@id="docs1View"]
		Thread.sleep(2000);
		SaveButton.click();
	}

	public void click_School_profile() {
		School_profile.click();

	}

	public void Click_Submit() {
		Submit.click();
	}

	public void Click_Reset() {
		Back.click();
	}

	public void filldata() throws Exception {
		ExcelReader er = new ExcelReader(
				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",
				0);
		Village();
		enter_pincode(er.getExcelData(1, 0));
		enter_School_Email_Id(er.getExcelData(1, 1));
		enter_School_Contact_No(er.getExcelData(1, 2));
		enter_Schoo_Website(er.getExcelData(1, 3));
		Thread.sleep(4000);
		enter_School_Registration_No(er.getExcelData(1, 4));

		WebElement date = driver
				.findElement(By.xpath("//input[@name='SchoolEstablishmentYear' and @id='SchoolEstablishmentYear']"));
		String dateval = "12/06/1960";
		selectDateByJs(driver, date, dateval);
		School_Board();
		Is_School_Under();
		IsITI();
		P_Full_Name(er.getExcelData(1, 5));
		MobileNumber(er.getExcelData(1, 6));
		Get_OTP_MobNum();
		EnterOTP();
		Verify_OTP_Mobile();
		p_Email_ID(er.getExcelData(1, 7));
		Get_Email_OTP();
		EnterEmailOTP();
		Verify_OTP_Gmail();
		C_Full_EnterName(er.getExcelData(1, 8));
		C_EnterMobileNumber(er.getExcelData(1, 9));
		C_GETMobilenumberOTP();
		C_EnterMobileOTP();
		Verify_OTP_CMobile();
		C_EnterEmail_ID(er.getExcelData(1, 10));
		Get_CEmail_OTP();
		EnterCEmailOTP();
		Verify_OTP_CGmail();
		EnterBank_Account_No(er.getExcelData(1, 11));
		GetOTPPrincipalMobileNumber();
		EnteraccontnoOTP();
		VerifyAccountHolderOTP();
		EnterAccountHolderName(er.getExcelData(1, 12));
		EnterIFSCCode(er.getExcelData(1, 13));
		Upload_document();
		View_Document();

		// C_Full_Name(er.getExcelData(1, 8));
		// C_MobileNumber(er.getExcelData(1, 9));
		// C_Email_ID(er.getExcelData(1, 10));

	}

	public static void selectDateByJs(WebDriver driver, WebElement element, String dateval) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + dateval + "');", element);
	}

	// a[contains(text(),'Back To Dashboard')]
	/*
	 * // Verify the page title public void verifytitle() { String expectedTitle =
	 * "aaplesarkar.mahaonline.gov.in"; String actualTitle = driver.getTitle(); if
	 * (actualTitle.equalsIgnoreCase(expectedTitle)) {
	 * System.out.println("Title is Matching"); } else {
	 * System.out.println("Title is Not Matching"); }
	 * 
	 * }
	 * 
	 * // Verify the page text public void verifytext() { String expectedText =
	 * "Right to Public Services Act"; String actualText =
	 * driver.findElement(By.xpath("//span[@class='green']")).getText();
	 * 
	 * if (actualText.equalsIgnoreCase(expectedText)) {
	 * System.out.println("Text is Matching"); } else {
	 * System.out.println("Text is not Matching"); } }
	 * 
	 * // Verify User Name public void verifyusername() { String expectedText =
	 * "Welcome, PRIYANKA SURESH JANGAM"; String actualText =
	 * driver.findElement(By.xpath("//*[@id=\"inbox\"]/div[2]")).getText(); if
	 * (actualText.equalsIgnoreCase(expectedText)) {
	 * System.out.println("User Name is Correct"); } else {
	 * System.out.println("User Name is Incorrect"); }
	 * 
	 * }
	 * 
	 * public void links() { // Find all link elements on the page
	 * java.util.List<WebElement> linkElements =
	 * driver.findElements(By.tagName("a")); System.out.println("Total Links" +
	 * linkElements.size());
	 * 
	 * }
	 * 
	 * public void marathielement() { boolean brnpresence =
	 * driver.findElement(By.xpath("/html/body/header/div[1]/div[4]/div/a")).
	 * isDisplayed(); System.out.println(brnpresence);
	 * Assert.assertTrue(brnpresence); }
	 * 
	 * public void Logoutbutton() { boolean logoutbuton =
	 * driver.findElement(By.xpath("//a[normalize-space()='Logout']")).isDisplayed()
	 * ; System.out.println("Logout Button Dispalyed" +logoutbuton);
	 * Assert.assertTrue(logoutbuton); } public void verifyLogo() {
	 * 
	 * String expectedText = "Government of Maharashtra"; String actualtext =
	 * driver.findElement(By.xpath("/html/body/header/div[1]/div[2]")).getText();
	 * 
	 * if (actualtext.equalsIgnoreCase(expectedText)) {
	 * System.out.println("Logo Name is Correct"); } else {
	 * System.out.println("Logo Name is Incorrect"); } } public void
	 * verifydashboardtext() { String expected = "Department Dashboard"; String
	 * actual =
	 * driver.findElement(By.xpath("//th[normalize-space()='Department Dashbaord']")
	 * ).getText();
	 * 
	 * if (actual.equalsIgnoreCase(expected)) {
	 * System.out.println("Text is Matching"); } else {
	 * System.out.println("Text is Not Matching");
	 * 
	 * }
	 * 
	 * }
	 */
}
