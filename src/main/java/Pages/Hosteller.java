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

public class Hosteller extends Prematric_base { // extend base class with this class to initialize

	@FindBy(xpath = "//*[@id='btnClear']")
	public WebElement Reset;

	@FindBy(xpath = "//*[@id=\"divHostel\"]/fieldset/div[2]/div/label[2]/span")
	public WebElement IsHosteller;

	@FindBy(xpath = "//*[@id=\"StateID\"]")
	public WebElement HostelType;

	@FindBy(xpath = "//*[@id=\"StateID\"]")
	public WebElement State;

	@FindBy(xpath = "//*[@id=\"DistrictID\"]")
	public WebElement District;

	@FindBy(xpath = "//*[@id=\"TalukaID\"]")
	public WebElement Taluka;

	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	public WebElement SaveButton;

	@FindBy(xpath="//button[@class='confirm']")
	public WebElement okbutton;
	
	public void click_okButton() {
		okbutton.click();
	}
	
	
	// Instantiate
	public Hosteller() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void click_Reset() throws InterruptedException {
		Reset.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(9000);


	}

	public void IsHosteller() {
		IsHosteller.click();
	}

	public void select_Hostel_Type() {
		WebElement HT = HostelType;
		Utility.selectOptionFromDropDown(HT, "Government Residential School");

	}

	public void Select_State() {
		WebElement otp = State;
		Utility.selectOptionFromDropDown(otp, "MAHARASHTRA");
	}

	public void Select_District() {
		WebElement Dist = District;
		Utility.selectOptionFromDropDown(Dist, "OSMANABAD");
		// captcha.click();
	}

	public void select_Taluka() {
		WebElement tal = Taluka;
		Utility.selectOptionFromDropDown(tal, "BHOOM");
	}

	public void Click_Save() throws InterruptedException {
		Thread.sleep(5000);
		SaveButton.click();
		Thread.sleep(3000);
		click_okButton();

		
	}
  
	public void Hosteller() throws Exception {
		click_Reset();
		ExcelReader er= new ExcelReader("C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx ", 1);
		IsHosteller();
		select_Hostel_Type();
		Select_State();
		Select_District();
		select_Taluka();
		Click_Save();
		
		
	
} 
}
