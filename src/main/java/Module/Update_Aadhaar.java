package Module;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

//import org.testng.Assert;

import Base.Prematric_base;
//import Utils.Utility;

public class Update_Aadhaar extends Prematric_base { // extend base class with this class to initialize

	// student update aadhaar
	
	SoftAssert as= new SoftAssert();

	@FindBy (xpath="//a [@href=\"/DBTDashboard/ViewCancelscheme\"]")
    public WebElement click_ViewCancelscheme;
    
   

	// Instantiate
	public Update_Aadhaar() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	 public void checkStatus(String app_id) throws Exception
	    {
	        int row_count= driver.findElements(By.xpath("//*[@id=\"WebGrid\"]/thead/tr/th[1]")).size();
	        System.out.println("Row count: "+row_count);
	        //soft sa = new softassert(); 
	                
	        for(int i=1; i<=row_count; i++ )
	        {
	        String status_text = driver.findElement(By.xpath("//table[@id=\"WebGrid\"]/tbody/tr["+i+"]/td[1]")).getText() ;
	        System.out.println(app_id + status_text);
	        if(    app_id.equalsIgnoreCase(status_text))
	        {
	            Thread.sleep(1000);
	            //System.out.println(i+driver.findElement(By.xpath("//table[@id=\"WebGrid\"]/tbody/tr["+i+"]/td[4]")).getText());
	            as.assertEquals(driver.findElement(By.xpath("//table[@id=\"WebGrid\"]/tbody/tr["+i+"]/td[4]")).getText(), "Application Canceled");
	        }
	        else
	        {
	            System.out.println("Application id not found");
	            as.assertTrue(false);
	        }

	
	
	
}}}
