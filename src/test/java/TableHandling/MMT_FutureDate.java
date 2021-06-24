package TableHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_FutureDate {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	    Actions actions= new Actions(driver);
	    actions.moveByOffset(20, 20);
	    
	    WebElement source = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement destination = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		
		source.sendKeys("Goa"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'GOI')]")).click(); 
		
		
		destination.sendKeys("Kolkata");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'CCU')]")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		System.out.println("Passed");
		driver.close();

	}

}
