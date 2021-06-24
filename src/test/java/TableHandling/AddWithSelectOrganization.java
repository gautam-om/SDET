package TableHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericUnit.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddWithSelectOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    
	   
	    					
         driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
         
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
         driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
         
         driver.findElement(By.name("accountname")).sendKeys("Gautam"+JavaUtility.getRandomData());
         driver.findElement(By.id("phone")).sendKeys("122536787");
         
         
         WebElement dropdown = driver.findElement(By.xpath("//option[@value='Chemicals']"));
         dropdown.click();
         WebElement dropdown1 = driver.findElement(By.xpath("//option[@value='Investor']"));
         dropdown1.click();
         WebElement dropdown2 = driver.findElement(By.xpath("//option[@value='Active']"));
         dropdown2.click();
         
         driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
         
          // Logout
         Thread.sleep(2000);
         Actions actions=new Actions(driver);
         actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         
         
         // closs window
         driver.close();

	}

}
