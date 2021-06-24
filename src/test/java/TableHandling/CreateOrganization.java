package TableHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.genericUnit.JavaUtility;
import com.crm.genericUnit.PropertyUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 
 * @author Gautam
 *
 */
public class CreateOrganization {
 
	
  
	
	public static void main(String[] args) throws Throwable {
		
		PropertyUtility pUnit= new PropertyUtility();
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    
	      //get url 
	     driver.get(pUnit.getPropertyKeyValue("url"));
	    					 
         driver.findElement(By.name("user_name")).sendKeys(pUnit.getPropertyKeyValue("username"));
         driver.findElement(By.name("user_password")).sendKeys(pUnit.getPropertyKeyValue("password"));
         driver.findElement(By.id("submitButton")).click();
         
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
         driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
         
         driver.findElement(By.name("accountname")).sendKeys("Gautam"+JavaUtility.getRandomData());
         driver.findElement(By.id("phone")).sendKeys("123456789");
         driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click(); 
         
         Thread.sleep(2000);
         Actions actions=new Actions(driver);
         actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         //driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
         

	}

}
