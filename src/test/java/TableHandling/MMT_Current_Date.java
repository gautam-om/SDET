package TableHandling;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.genericUnit.JsonDataUtility;
import com.crm.genericUnit.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_Current_Date {     
	
	

	public static void main(String[] args) throws Throwable {
		
		// Read Data from json file
		JsonDataUtility jdu = new JsonDataUtility();
		
		
		WebDriverUtility wdu= new WebDriverUtility();
		
		
		   Date dateobj = new Date();

		  System.out.println(dateobj.toString());

		  //  Mon Jun 21 11:43:05 IST 2021
		  //  0     1  2   3        4    5

		  String todaysdate = dateobj.toString();

		  String arr[]=todaysdate.split(" ");

		  String day=arr[0];

		  String month = arr[1];

		  String date = arr[2];

		  String year=arr[5];

		  String currentDate= day+" "+month+" "+date+" "+year;

		  System.out.println(currentDate);
		
	    WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		String URL = jdu.readDataFromJSON("mmturl");
		driver.get(URL);
		wdu.pageMaximize(driver);
		wdu.waitUntilPageLoad(driver);
		//driver.get("https://www.makemytrip.com/");
		//driver.manage().window().maximize();
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		WebElement source = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement destination = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		
		source.sendKeys("Goa"); 
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[contains(text(),'GOI')]")).click(); 
		
		
		destination.sendKeys("Kolkata");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[contains(text(),'CCU')]")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		Thread.sleep(7000);
		
		//driver.findElement(By.xpath("//div[@aria-label='Fri Jun 25 2021']"));
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		System.out.println("Script pass");
		
		driver.close();
	}

}
