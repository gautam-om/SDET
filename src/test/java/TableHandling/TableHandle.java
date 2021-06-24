package TableHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUnit.JsonDataUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHandle {

	public static void main(String[] args) throws Throwable {
		
		JsonDataUtility jdu = new JsonDataUtility();
		String URL = jdu.readDataFromJSON("uril");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    System.out.println("Passed");

	}

}
