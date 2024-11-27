package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Prematric_base;
import Utils.ExcelReader;
import Utils.Utility;
//import Utils.Utility;

public class Other_Information extends Prematric_base { // extend base class with this class to initialize

	
	@FindBy(xpath = "//*[@id='btnClear']")
	public WebElement reset;

	@FindBy(xpath = "//*[@id=\"ParentDetails\"]/div[2]/div/label[2]")
	public WebElement IsFatherAlive;

	@FindBy(xpath = "//*[@id='FatherName']")
	public WebElement FatherName;

	@FindBy(xpath = "//*[@id='FatherOccupationID']")
	public WebElement Occupation;

	@FindBy(xpath = "//*[@id='MotherName']")
	public WebElement IsMotherAlive;

	@FindBy(xpath = "//*[@id='MotherName']")
	public WebElement MotherName;

	@FindBy(xpath = "//*[@id='MotherOccupationID']")
	public WebElement M_Occupation;

	@FindBy(xpath = "//*[@id='btnAdd']")
	public WebElement SaveButn;
	
	@FindBy(xpath = "//button[@class='confirm']")
	public WebElement OkBtn;
	
		
	public void click_okButton()
	{
		OkBtn.click();
	}

	// Instantiate
	public Other_Information() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void Click_Reset() throws InterruptedException {
		
		reset.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(9000);
		
	}

	public void selectIsFatherAlive() {
		IsFatherAlive.click();
	}

	public void EnterFatherName(String Fathername) {
		FatherName.sendKeys(Fathername);

	}

	public void F_Occupation() {
		WebElement FM = Occupation;
		Utility.selectOptionFromDropDown(FM, "Unclean");
	}

	public void IsMotherAlive() {
		IsMotherAlive.click();

	}

	public void EnterMotherName(String Mname) {
		MotherName.sendKeys(Mname);
	}

	public void select_M_Occupation() {
		WebElement MN = M_Occupation;
		Utility.selectOptionFromDropDown(MN, "Agriculture");

	}

	public void Enter_Save() throws InterruptedException {
		Thread.sleep(5000);
		SaveButn.click();
		Thread.sleep(3000);
		click_okButton();
	}

	
	public void Other_details() throws Exception {
		Click_Reset();
		
		ExcelReader er = new ExcelReader(
				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",
				1);
		
		selectIsFatherAlive();
		EnterFatherName(er.getExcelData(1, 0));
		F_Occupation();
		IsMotherAlive();
		EnterMotherName(er.getExcelData(1, 1));
		select_M_Occupation();
		Enter_Save();
		
			
	} 
}
