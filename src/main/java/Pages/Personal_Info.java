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
import Utils.ExcelReader;
//import Utils.Utility;
import Utils.Utility;

public class Personal_Info extends Prematric_base { // extend base class with this class to initialize

	// student update aadhaar
	@FindBy(xpath = "//*[@id=\"btnClear\"]")
	public WebElement Reset;

	@FindBy(xpath = "//*[@id=\"divpersonal\"]/fieldset[3]/div[2]/div/label[2]/span")
	public WebElement Residentmaha;

	@FindBy(xpath = "//*[@id=\"FamillyAnnualIncomeNoBarcode\"]")
	public WebElement FamilyIncome;

	@FindBy(xpath = "//*[@id=\"divpersonal\"]/fieldset[5]/div[1]/div/label[2]/span")
	public WebElement DisabilityYES;

	@FindBy(xpath = "//*[@id=\"DisabilityType\"]")
	public WebElement DisabilityType;

	@FindBy(xpath = "//*[@id=\"PersonWithDisabilityID\"]")
	public WebElement Persondisability;

	@FindBy(xpath = "//*[@id=\"PersonWithDisabilityID\"]")
	public WebElement DisabilityPercentage;

	@FindBy(xpath = "//*[@id=\"PersonWithAddiDisabilityID\"]")
	public WebElement  Additionaldisability;

	@FindBy(xpath = "//*[@id=\"IsDisabilityDiv\"]/div[5]/div/label[2]")
	public WebElement  hearingimpairement;

	@FindBy(xpath = "//*[@id=\"IsDisabilityDiv\"]/div[4]/div/label[2]/span")
	public WebElement Disabilitytarinee;

	@FindBy(xpath = "//*[@id=\"divpersonal\"]/fieldset[5]/div[5]/div/label[2]/span")
	public WebElement BPL;

	@FindBy(xpath = "//*[@id=\"divpersonal\"]/fieldset[5]/div[6]/div/label[3]/span")
	public WebElement mentally_ill;

	@FindBy(xpath = "//*[@id=\"divpersonal\"]/fieldset[5]/div[7]/div/label[3]/span")
	public WebElement hearing_impairement;

	@FindBy(xpath = "//*[@id=\"NoOfChildInFamily\"]")
	public WebElement Childnofamily;

	@FindBy(xpath = "//*[@id=\"MobileNo\"]")
	public WebElement MobileNO;

	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	public WebElement Savebtn;

	@FindBy(xpath = "//*[@id=\"btnClear\"]")
	public WebElement Resetbtn;
	
	@FindBy(xpath = "//button[@class = 'confirm' and text()='OK']") //
	private WebElement OkBtn;
	
	public void click_okBtn()
	{
		OkBtn.click();
	}
	

	// Instantiate
	public Personal_Info() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void Click_Reset() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
						
		Reset.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(9000);
	}

	public void resident_of_Maha() {
		Residentmaha.click();
	}
	

	public void Family_Income(String FM) {
		FamilyIncome.sendKeys(FM);

	}

	public void Disability_TypeYESNO() {
		DisabilityYES.click();

	}

	public void Disability_Type() {
		WebElement DT = DisabilityType;
		Utility.selectOptionFromDropDown(DT, "Permanent");

	}

	public void Person_with_Disability() {
		WebElement PD = Persondisability;
		Utility.selectOptionFromDropDown(PD, "Blindness");
	}

	public void Disability_Percentage(String DP) {
		DisabilityPercentage.sendKeys(DP);
	}

	public void Additional_disability() {
		WebElement AD = Additionaldisability;
		Utility.selectOptionFromDropDown(AD, "Mental Illness");

	}
	
	public void Hearing_ImpairementYesNo() {
		hearingimpairement.click();
	}
	
	public void IsDisableTraineeInWorkshop() {
		Disabilitytarinee.click();
	}

	public void AreyouBPL() {
		BPL.click();
	}

	
	public void NumberinFamily(String FM) {
		Childnofamily.sendKeys(FM);
	}

	public void MobileNumber(String MB) {
		MobileNO.sendKeys(MB);
		// captcha.click();
	}

	public void SaveButton() throws InterruptedException {
		Thread.sleep(5000);
		Savebtn.click();
		Thread.sleep(3000);
		click_okBtn();
		
		
		
		// captcha.click();
	}

//	public void ResetButton() {
//		Resetbtn.click();
//		// captcha.click();
//	}

	
	public void person_info() throws Exception {
		// TODO Auto-generated method stub
	ExcelReader er1 = new ExcelReader(
				"C:\\Users\\Santosh.Satpute\\eclipse-workspace\\PrematricProject\\src\\main\\java\\TestData\\Testdata.xlsx",1);
		
		Click_Reset();
		resident_of_Maha();
		Family_Income(er1.getExcelData(1, 0));
		// Select_Gender();
		Disability_TypeYESNO();
		Disability_Type();
		Disability_Percentage(er1.getExcelData(1, 1));
		Additional_disability();
		Hearing_ImpairementYesNo();
		IsDisableTraineeInWorkshop();
		AreyouBPL();
		NumberinFamily(er1.getExcelData(1,2));
		MobileNumber(er1.getExcelData(1,3));
		SaveButton();
		
		// Back_button();
	

	}
}
