/**
 * 
 */
package Listener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.Prematric_base;
import Utils.ExtentReportGenerated;

public class MyListener extends Prematric_base implements ITestListener {
	
	WebDriver driver ; 

	ExtentReports report = ExtentReportGenerated.getExtentReport();
	ExtentTest etest;

	public void onTestStart(ITestResult result) {

		String testName = result.getName();

		// ExtentReportGenerator.getExtentReport()

		etest = report.createTest(testName);
		etest.log(Status.INFO, testName + "execution started");

	}

	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		etest.log(Status.PASS, testName + "Got Successfuly Executed");
		etest.assignAuthor("Santosh satpute");
	}

	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
		etest.log(Status.FAIL, testName + "got failed");
		etest.assignAuthor("Santosh satpute");

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	etest.addScreenCaptureFromPath(takeScreenshot(testName, driver), testName);
		etest.log(Status.INFO, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		String testName = result.getName();

		etest.log(Status.SKIP, testName + "got skipped");
		etest.log(Status.INFO, result.getThrowable());
     	etest.assignAuthor("Santosh satpute");
	}

	public void onFinish(ITestContext context) {

		// String testName=result.getName();

		report.flush();
		File eReportsFile = new File(System.getProperty("user.dir") + "\\ExtentReports\\eReport.html");
		try {
			Desktop.getDesktop().browse(eReportsFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish1(ITestContext context) {
		File eReportsFile1 = new File(System.getProperty("user.dir") + "\\reports\\eReport1.html");
    	report.flush();
		try {
			Desktop.getDesktop().browse(eReportsFile1.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}
}
