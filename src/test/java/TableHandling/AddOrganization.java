package TableHandling;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.genericUnit.JavaUtility;
import com.crm.genericUnit.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddOrganization {

	public static void main(String[] args) throws Throwable {
		
		
		// launch chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    
	   
	     //put the user name and password		
         driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
         
         //click on organization
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
        
         // create organization
         driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
         
         //inter name and phone Number
         driver.findElement(By.name("accountname")).sendKeys("Prakash"+JavaUtility.getRandomData()); 
         driver.findElement(By.id("phone")).sendKeys("123000087");
         
        
          //save	
         driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
        
         //Logout
          Thread.sleep(2000);
          Actions actions=new Actions(driver);
          actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
          driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
          System.out.println("Scrip Pass");
          driver.close();
	}


}


