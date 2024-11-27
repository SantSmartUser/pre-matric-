package Pages;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Base.Prematric_base;
import Utils.Utility;

import Utils.ExcelReader;

public class Apply_scheme extends Prematric_base { // extend base class with this class to initialize

	@FindBy(xpath = "//a[contains(text(),'Apply Scheme')]")
	private WebElement Applyscheme;

	@FindBy(xpath = "//*[@id='StandardID']")
	private WebElement Standard;

	@FindBy(xpath = "//*[@id='CasteID']")
	private WebElement Caste;

	@FindBy(xpath = "//*[@id='GenderID']")
	private WebElement Gender;

	@FindBy(xpath = "//*[@id='SaralID']")
	private WebElement Saral_ID;

	@FindBy(xpath = "//*[@id='AcademicYearID']")
	private WebElement academic_year;

	@FindBy(xpath = "//*[@id='btnShow']")
	private WebElement Shoewbtn;

	@FindBy(xpath = "//a[contains(text(),'Go Back')]") // a[contains(text(),'Go Back')]
	private WebElement BKbt;

	@FindBy(xpath = "//button[@id='btnClear']") // clear
	private WebElement Clearbt;

	// Instantiate
	public Apply_scheme() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

//	public void Village() {
//		WebElement VL = village;
//		Utility.selectOptionFromDropDown(VL, "CHIKHLI (N.P.)");
//
//	}
	SoftAssert sa = new SoftAssert();

	public void Apply_schem_School_profile() {
		Applyscheme.click();
	}

	public void select_Standard() {
		WebElement ST = Standard;
		Utility.selectOptionFromDropDown(ST, "10th Standard (SSC)");
	}

	public void select_Caste() {
		WebElement Cst = Caste;
		Utility.selectOptionFromDropDown(Cst, "SC");

	}

	public void Enter_Showbtn() {
		Shoewbtn.click();

	}

	public void stud() throws Exception {
		// TODO Auto-generated method stub
//		ExcelReader er1 = new ExcelReader(
//				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",1);
		// click_schoolProfile_Tab();
		Apply_schem_School_profile();
		select_Standard();
		select_Caste();
		// Select_Gender();
		// Academic_Year();
		Enter_Showbtn();
		Apply_scheme_Information();
		// Back_button();

	}

	public void Apply_scheme_Information() throws InterruptedException {
		Thread.sleep(1000);

		int row_size = driver.findElements(By.xpath("//table//tbody//tr")).size();

		System.out.println(row_size);
		for (int i = 1; i <= row_size; i++) {

			String status = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td")).getText();
			System.out.println(status);

			if (status.equalsIgnoreCase("2015272901018020002")) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//table//tbody//tr[5]//td[5")).click();

				System.out.println("found");

			}
		}
	}

}
