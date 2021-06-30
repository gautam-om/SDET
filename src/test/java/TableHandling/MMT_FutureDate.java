package TableHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.genericUnit.JsonDataUtility;
import com.crm.genericUnit.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_FutureDate {

	public static void main(String[] args) throws Throwable {
		
		JsonDataUtility jdu = new JsonDataUtility();
		String URL = jdu.readDataFromJSON("urel");
		
		WebDriverUtility wdu= new WebDriverUtility();
		
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		wdu.waitUntilPageLoad(driver);
	    
	    
	    Thread.sleep(7000);
	    WebElement source = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement destination = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		
		source.sendKeys("Goa"); 
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'GOI')]")).click(); 
		
		
		destination.sendKeys("Kolkata");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'CCU')]")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@aria-label='Sat Oct 02 2021']")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		
		System.out.println("Passed");
		//driver.close();

	}

}
