package Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import Base.Prematric_base;
import Utils.Utility;
//import Utils.Utility;

public class Student_Profile extends Prematric_base { // extend base class with this class to initialize

	// student update aadhaar

	@FindBy(xpath = "//*[@id=\"StandardID\"]") //// *[@id="details-button"]
	public WebElement Standard;

	@FindBy(xpath = "//*[@id=\"CasteID\"]") //// *[@id="details-button"]
	public WebElement Caste;

	@FindBy(xpath = "//*[@id=\"GenderID\"]")
	public WebElement Gender;

	@FindBy(xpath = "//*[@id=\"SaralID\"]")
	public WebElement Saral_ID;

	@FindBy(xpath = "//*[@id=\"btnShow\"]")
	public WebElement Showbtn;

	// nstantiate
	public Student_Profile() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void select_Standard() {
		WebElement STD = Standard;
		Utility.selectOptionFromDropDown(STD, "10th Standard (SSC)");
	}

	public void Select_Caste() {
		WebElement CST = Caste;
		Utility.selectOptionFromDropDown(CST, "SC");
	}

	public void Select_Gender() {
		WebElement GN = Gender;
		Utility.selectOptionFromDropDown(GN, "Female");
	}

	public void Select_Saral_ID(String srlID) {
		Saral_ID.sendKeys(srlID);
	}

	public void Click_Show_btn() {
		Showbtn.click();
	}
	public void  select_Update_Aadhaar() throws InterruptedException {
		Thread.sleep(1000);
		//softAssert1.assertEquals(Under_portal_text.getText(),"Under portal  Applications");
		int row_size = driver.findElements(By.xpath("//*[@id=\"WebGrid\"]/thead/tr")).size();
		for(int i=1; i<=row_size; i++)
		{
			
			String status = driver.findElement(By.xpath("//*[@id=\"tab_default_11\"]/div/div/table/tbody/tr["+ i+ "]/td[5]")).getText();
		}
	 
}}


