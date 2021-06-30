package TableHandling;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.genericUnit.ExcelUtility;
import com.crm.genericUnit.JavaUtility;
import com.crm.genericUnit.JsonDataUtility;
import com.crm.genericUnit.PropertyUtility;
import com.crm.genericUnit.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Gautam
 *
 */
public class WindowHandleVtiger {

	@Test
	public static void main(String[] args) throws Throwable {
		
		// create object WebDriverUtility
		WebDriverUtility wdu= new WebDriverUtility();
		
		
		ExcelUtility eu= new ExcelUtility();
		String excel = eu.getFromDataExcel("Sheet1", 1, 1);
		System.out.println(excel);
		
		JsonDataUtility jdu=new JsonDataUtility();
		String URL = jdu.readDataFromJSON("url");
		String USERNAME = jdu.readDataFromJSON("username");
		String PASSWORD = jdu.readDataFromJSON("password");
		
		// Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(URL);
		driver.manage().window().maximize();
		wdu.waitUntilPageLoad(driver); 
					
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         driver.findElement(By.id("submitButton")).click();
         
         wdu.waitUntilPageLoad(driver);
        
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
         driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
         
         driver.findElement(By.name("accountname")).sendKeys("Om"+JavaUtility.getRandomData());
         driver.findElement(By.id("phone")).sendKeys("19345658");
         
         WebElement selectoption = driver.findElement(By.name("industry")); 
         wdu.selectOption(selectoption, "Biotechnology");
         WebElement selectindex = driver.findElement(By.name("accounttype"));
         wdu.selectOption(selectindex, 5);
         
         
         
         driver.findElement(By.xpath("//img[contains(@title,'Select')]")).click();;
         wdu.switchToWindow(driver,"Accounts");
         Thread.sleep(2000);
         driver.findElement(By.xpath("//a[text()='Rahul']")).click();
         wdu.acceptAlert(driver);
         wdu.switchToWindow(driver,"action");
        
         // Logout
         Thread.sleep(2000);
         WebElement mouseOverr = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         wdu.mouseOver(driver, mouseOverr);
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         System.out.println("Scrip Passed");
         driver.close();
       
	}

}
