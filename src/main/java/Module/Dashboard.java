package Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Base.Prematric_base;
//import Utils.Utility;

public class Dashboard extends Prematric_base { // extend base class with this class to initialize

	// @FindBy(xpath = "//a[normalize-space()='English']")

	// public WebElement Language;

	@FindBy(xpath = "//a[@href='/Pre_StudentInfo/Pre_DashBoard']")

	private WebElement dashboard;

	@FindBy(xpath = "//*[@id=\"TheForm\"]/div[1]/div/a") //// *[@id="details-button"]
	public WebElement Total_Students;

	@FindBy(xpath = "//a[contains(text(),'Back To Dashboard')]") //// *[@id="details-button"]
	public WebElement Back;

	// Instantiate
	public Dashboard() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void click_ON_Dahboard() {
		dashboard.click();

	}

	public void Total_students() {
		Total_Students.click();
	}

	public void Back_Button() {
		Back.click();
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
