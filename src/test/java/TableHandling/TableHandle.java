package TableHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	    
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr"));
	    int count = rows.size();
	     
//	    for(int i=1;i<=count; i++);
//	    {
//	    	for(int j=1;j<=5; j++)
//	    	{
//				
//				WebElement tprint = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+i+"]/td["+j+"]"));
//	    		tprint.getText();
//	    		System.out.print(tprint);
//	    		System.out.println(" ");
//	    		
//	    	}
//	    	
//	    	System.out.println("");
//	    }
	    Thread.sleep(10000);
	    List<WebElement> rows1 = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr[*]/td[1]"));
	    
	    for(int i=0; i<rows1.size(); i++)
	    {
	    	System.out.println(rows1.get(i).getText());
	    }
	    System.out.println("Passed");
	    
	    driver.close();
	}

}
