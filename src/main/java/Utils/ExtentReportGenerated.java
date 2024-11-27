package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Prematric_base;


public class ExtentReportGenerated extends Prematric_base {
	public static ExtentReports getExtentReport() {

		ExtentReports extent = new ExtentReports();

		File file = new File(System.getProperty("user.dir") + "\\ExtentReports\\eReport.html");

		ExtentSparkReporter sparkReprter = new ExtentSparkReporter(file);

		sparkReprter.config().setTheme(Theme.DARK);

		sparkReprter.config().setReportName("Prematric page Test result");

		sparkReprter.config().setDocumentTitle("Prematric page Test result");

		// sparkReprter.config().setCss(null);

		extent.attachReporter(sparkReprter);

		return extent;
	}
}
