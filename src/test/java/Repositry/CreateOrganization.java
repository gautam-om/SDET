package Repositry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.genericUnit.JavaUtility;
import com.crm.genericUnit.JsonDataUtility;
import com.crm.genericUnit.WebDriverUtility;
import com.crm.pageobject.CreateOrganizationPage.CreateOrganisationPage;
import com.crm.pageobject.HomePage;
import com.crm.pageobject.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {
	
	//public static void main(String[] args) throws Throwable {
	@Test
    public  void CreateOrganizationJson() throws Throwable {
		
		WebDriverUtility wdu=new WebDriverUtility();
		 
	    JsonDataUtility juti= new JsonDataUtility();
		    String URL = juti.readDataFromJSON("url");
		    String USERNAME = juti.readDataFromJSON("username");
		    String PASSWORD = juti.readDataFromJSON("password");
	
		    WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
		    wdu.pageMaximize(driver); 
		    wdu.waitUntilPageLoad(driver);
	    
	      //get url
	     driver.get(URL);
	    //login to application		
	     
	     LoginPage lg=new LoginPage(driver);
	     lg.login(USERNAME, PASSWORD);
	     
	     HomePage hp= new HomePage(driver);
	     wdu.waitUntilPageLoad(driver);
	     hp.clickOrganization();
	     hp.clickSign();
	     
//	     CreateOrganisationPage cog = new CreateOrganisationPage(driver);
//	     cog.createOrganization(orgName, industryType);
	     
	     

        Thread.sleep(2000);  
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        //driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();

  }
}
