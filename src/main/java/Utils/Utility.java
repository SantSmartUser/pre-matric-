package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Prematric_base;

public class Utility extends Prematric_base {

	static WebDriver driver;
	// public static WebDriverWait wait = new WebDriverWait(driver,
	// Duration.ofSeconds(15));

	Utility(WebDriver driver) {
		this.driver = driver;
	}

	public static String HandleAlert(WebDriver driver, int wait1) {
		String msg = "";
		try { // TODO Auto-generated method stub

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wait1));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			System.out.println("Alert text:" + msg);

			alert.accept();

		} catch (NoAlertPresentException e) {
			System.out.println("No alert present.");

		}
		return msg;
	}

	public static void selectOptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	public static void windowhandle() throws Exception {
		Set<String> allwins = driver.getWindowHandles();
		Thread.sleep(2000);
		List<String> hlist = new ArrayList<String>(allwins);
		Thread.sleep(2000);

		if (switchtoRightwindow("WRD", hlist)) {

			Thread.sleep(2000);
			System.out.println(driver.getTitle());

		}
	}

	public static boolean switchtoRightwindow(String windowTitle, List<String> hlist) {
		for (String e : hlist) {
			String title = driver.switchTo().window(e).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("Found the right window");
				return true;
			}
		}
		return false;
	}

	public static void selectDateByJs(WebDriver driver, WebElement element, String dateval) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + dateval + "');", element);

	}

	
}
