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
//import Utils.Utility;
import Utils.ExcelReader;

public class Address extends Prematric_base { private static final WebElement SaveButton = null;

// extend base class with this class to initialize

	// student update aadhaar

	@FindBy(xpath = "//button[@id='btnClear']") //// *[@id="details-button"]
	public WebElement Resetbtn;

	@FindBy(xpath = "//*[@id=\"Address\"]") //// *[@id="details-button"]
	public WebElement Address;

	@FindBy(xpath = "//*[@id='StateID']")
	public WebElement State;

	@FindBy(xpath = "//*[@id='DistrictID']")
	public WebElement District;

	@FindBy(xpath = "///*[@id='TalukaID']")
	public WebElement Taluka;

	@FindBy(xpath = "//*[@id='VillageID']")
	public WebElement Village;

	@FindBy(xpath = "//*[@id=\"Pincode\"]")
	public WebElement Pincode;

	@FindBy(xpath = "//button[@id='btnAdd']")
	public WebElement Savebtn;
	
	@FindBy(xpath = "//button[@class='confirm']") //
	private WebElement OkBtn;
	
	public void click_okButton()
	{
		OkBtn.click();
	}
	
	
	// Instantiate
	public Address() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void EnterReset() throws InterruptedException {
		Resetbtn.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
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

	public void EnterAddress(String address) {
		Address.sendKeys(address);
	}

	public void SelectState(String state) {
		State.sendKeys(state);

	}

	public void SelectDistrict(String dist) {
		District.sendKeys(dist);
	}

	public void SelectTaluka(String Tal )  {
		Taluka.sendKeys(Tal);
		
	}

	public void Select_Village(String Vil) {
		Village.sendKeys(Vil);
	}

	public void select_Pincode(String Pin) {
		Pincode.sendKeys(Pin);
	}

	public void EnterSave() throws InterruptedException {
		
		Thread.sleep(5000);
		Savebtn.click();
		Thread.sleep(3000);
		click_okButton();
	
	
	}

	
	public void addDetails() throws Exception {
		ExcelReader er = new ExcelReader(
				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",
				1);
		EnterReset();
		EnterAddress(er.getExcelData(1, 0));	
		SelectState(er.getExcelData(1, 1));
		SelectDistrict(er.getExcelData(1, 2));
		SelectTaluka(er.getExcelData(1, 3));
		Select_Village(er.getExcelData(1, 4));
		select_Pincode(er.getExcelData(1, 5));
		EnterSave();
		
	}
	
}
