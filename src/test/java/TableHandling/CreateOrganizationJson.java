package TableHandling;

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
import com.crm.genericUnit.PropertyUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class CreateOrganizationJson {
	
	@Test
     public  void CreateOrganizationJson() throws Throwable {
		 
	    JsonDataUtility juti= new JsonDataUtility();
		    String URL = juti.readDataFromJSON("url");
		    String USERNAME = juti.readDataFromJSON("username");
		    String PASSWORD = juti.readDataFromJSON("password");
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    
	      //get url
	     driver.get(URL);
	    //login to application				 
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
         
         //Navigate to organization
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
         
         // navigate to create organization
         driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
         driver.findElement(By.name("accountname")).sendKeys("Gautam"+JavaUtility.getRandomData());
         driver.findElement(By.id("phone")).sendKeys("123456789");
         
         WebElement dropddown = driver.findElement(By.xpath("//select[@name='industry']"));
         //WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='rating']"));
         
         Select sl = new Select(dropddown);
         sl.selectByIndex(3);	
         
         driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click(); 
         
         Thread.sleep(2000);  
         Actions actions=new Actions(driver);
         actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         //driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
}       

}
