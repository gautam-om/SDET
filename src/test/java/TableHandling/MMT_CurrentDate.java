package TableHandling;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_CurrentDate {

	public static void main(String[] args) throws Throwable {
		
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
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		    WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		    
		    src.sendKeys("GOA");
		    src.click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[contains(text(),'GOI')]")).click();
		    
		    
		    WebElement dest = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		    dest.click();
		    dest.sendKeys("KOLKATA");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[contains(text(),'CCU')")).click();
		    
		    driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		    
		    driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		    
		    
		    
//		  Object src = driver.findElement(By.xpath("//input[@id='fromCity']"));
//
//		  WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
//		  
//		  src.sendKeys("GOA");
//		  Thread.sleep(2000);
//		  driver.findElement(By.xpath("//div[contains(text(),'GOI')]")).click(); 
//
//		  dest.sendKeys("KOLKATA");
//		  Thread.sleep(2000);
//		  driver.findElement(By.xpath("//div[contains(text(),'CCU')]")).click();
//
//		  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
//
//		  Thread.sleep(2000);
//
//		 
//		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();

		 }

		

	}


