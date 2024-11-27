package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Prematric_base;
//import Utils.Utility;
import Utils.ExcelReader;
import Utils.Utility;

public class Education_Details extends Prematric_base { // extend base class with this class to initialize

	// student update aadhaar

	@FindBy(xpath = "//*[@id='btnClear']")
	public WebElement Reset;

	@FindBy(xpath = "//*[@id='Attendance']")
	public WebElement PreviousYearAttendance;

	@FindBy(xpath = "//*[@id='RankInClass']")
	public WebElement PreviousYearRankInClassRoom;

	@FindBy(xpath = "//*[@id='Percentage']")
	public WebElement PreviousYearPercentage;

	@FindBy(xpath = "//*[@id='GradeID']")
	public WebElement Previous_Yr_Grade;

	@FindBy(xpath = "//*[@id='AdmissionDate']")
	public WebElement AdmissionDate;

	@FindBy(xpath = "//input[@id='IsGap' and @value ='0']")
	public WebElement WasanyGapinthisQualificationCourse;

	@FindBy(xpath = "//button[@id='btnAdd']")
	public WebElement Savebtn;

	@FindBy(xpath = "//button[@class='confirm']")
	public WebElement OkBtn;

	public void click_okButton() {
		OkBtn.click();
	}

	// Instantiate
	public Education_Details() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void Click_reset() throws InterruptedException {
		Reset.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(9000);

//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert al = driver.switchTo().alert();
//		al.accept();
//		Thread.sleep(9000);

	}

	public void Previous_Year_Attendance(String p_Attendance) {
		PreviousYearAttendance.sendKeys(p_Attendance);
	}

	public void Previous_Year_Rank_In_Class_Room(String Preyearrank) {
		PreviousYearRankInClassRoom.sendKeys(Preyearrank);

	}

	public void Previous_Year_Percentage(String Preyearpercentage) {
		PreviousYearPercentage.sendKeys(Preyearpercentage);
	}

	public void Previous_Year_Grade() {
		WebElement PYG = Previous_Yr_Grade;
		Utility.selectOptionFromDropDown(PYG, "A+");

	}

	public void Admission_Date() {
		AdmissionDate.click();

	}

	public void Was_any_Gap() {
		WasanyGapinthisQualificationCourse.click();
	}

	public void Click_Save() throws InterruptedException {

		Thread.sleep(5000);
		Savebtn.click();
		Thread.sleep(3000);
		click_okButton();

	}

	public void Edu_Details() throws Exception {
		Click_reset();
		ExcelReader er = new ExcelReader(
				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",
				1);
		Previous_Year_Attendance(er.getExcelData(1, 0));
		Previous_Year_Rank_In_Class_Room(er.getExcelData(1, 1));
		Previous_Year_Percentage(er.getExcelData(1, 2));
		Previous_Year_Grade();
		WebElement date = driver.findElement(By.xpath("//input[@name='AdmissionDate' and @id= 'AdmissionDate']"));
		String dateval = "12/06/1961";
		Utility.selectDateByJs(driver, date, dateval);

		Was_any_Gap();
		Click_Save();

	}

	// calendare code
//	{
//	WebElement date = driver
//			.findElement(By.xpath("//input[@name='SchoolEstablishmentYear' and @id='SchoolEstablishmentYear']"));
//	String dateval = "12/06/1960";
//	selectDateByJs(driver, date, dateval);
//	}
//
//public static void selectDateByJs(WebDriver driver, WebElement element, String dateval) {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].setAttribute('value','" + dateval + "');", element);
}
