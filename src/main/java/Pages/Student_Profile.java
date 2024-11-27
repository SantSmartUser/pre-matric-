package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Base.Prematric_base;
import Utils.ExcelReader;
import Utils.Utility;

public class Student_Profile extends Prematric_base { // extend base class with this class to initialize

	// student update aadhaar
	@FindBy(xpath = "//*[@id=\"inner-content-div\"]/ul/li[3]/a")
	private WebElement studentprofile;

	@FindBy(xpath = "//*[@id='StandardID']")
	private WebElement Standard;

	@FindBy(xpath = "//*[@id=\"CasteID\"]")
	private WebElement Caste;

	@FindBy(xpath = "//*[@id=\"GenderID\"]")
	private WebElement Gender;

	@FindBy(xpath = "//*[@id=\"SaralID\"]")
	private WebElement Saral_ID;

	@FindBy(xpath = "//*[@id=\"AcademicYearID\"]")
	private WebElement academic_year;
	
	
	@FindBy(xpath = "//*[@id=\"btnShow\"]")
	private WebElement Shoewbtn;

	@FindBy(xpath = "//a[contains(text(),'Go Back')]") // a[contains(text(),'Go Back')]
	private WebElement BKbt;

	@FindBy(xpath = "//button[@id='btnClear']") // clear
	private WebElement Clearbt;

	// Instantiate
	public Student_Profile() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void click_student_Profile_Tab() {
		studentprofile.click();
	}

	public void select_Standard() {
		WebElement ST = Standard;
		Utility.selectOptionFromDropDown(ST, "10th Standard (SSC)");
	}

	public void select_Caste() {
		WebElement Cst = Caste;
		Utility.selectOptionFromDropDown(Cst, "SC");

	}

//	public void Select_Gender() {
//		WebElement GN = Gender;
//		Utility.selectOptionFromDropDown(GN, "Female");
//	}

//	public void Entersaral_ID(String saralid) {
//		Saral_ID.sendKeys(saralid);
//
//	}

	
	public void Enter_Showbtn() {
		Shoewbtn.click();

	}

	
	// click on upadte aadhaar

	public void stud() throws Exception {
		// TODO Auto-generated method stub
//		ExcelReader er1 = new ExcelReader(
//				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",1);
		// click_schoolProfile_Tab();
		click_student_Profile_Tab();
		select_Standard();
		select_Caste();
		// Select_Gender();
		//Academic_Year();
		Enter_Showbtn();
		Student_Information();
		// Back_button();
	

	}

	public void Student_Information() throws InterruptedException {
		Thread.sleep(1000);

		int row_size = driver.findElements(By.xpath("//table//tbody//tr")).size();

		System.out.println(row_size);
		for (int i = 1; i <= row_size; i++) {

			String status = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td")).getText();
			System.out.println(status);

			if (status.equalsIgnoreCase("2015272901018020002")) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//table//tbody//tr[1]//td[5]")).click();

				System.out.println("found");

				// driver.close();
			}
		}

	}

}
