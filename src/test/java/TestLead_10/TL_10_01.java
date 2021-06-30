package TestLead_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUnit.JavaUtility;
import com.crm.genericUnit.JsonDataUtility;
import com.crm.genericUnit.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TL_10_01 {

	public static void main(String[] args) throws Throwable {
		
		         // create WebDriverUtility object
                 WebDriverUtility wdu = new WebDriverUtility();        
		
		        // create object jsonDataUtility
				JsonDataUtility jdu = new JsonDataUtility();
				String URL = jdu.readDataFromJSON("url");
				String USERNAME = jdu.readDataFromJSON("username");
				String PASSWORD = jdu.readDataFromJSON("password");
				String Description = jdu.readDataFromJSON("description");
				
				// browser Launch
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				wdu.waitUntilPageLoad(driver);
				wdu.pageMaximize(driver);
				
				// driver get url
				driver.get(URL);
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click();	
				
		        //click on create Lead Image
		        Thread.sleep(7000);
		        driver.findElement(By.xpath("//a[text()='Leads']")).click();
		        
		      //create lead image
		        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		        
		        // select by index 
		        WebElement sarname = driver.findElement(By.name("salutationtype"));
		        wdu.selectOption(sarname, 1);
		        
		        // Enter valid inputs to all the fields.
		        WebElement fname = driver.findElement(By.name("firstname"));
		        fname.sendKeys("Om"+JavaUtility.getRandomData());
		        
		       // select by radiobutton
		        Thread.sleep(2000);
		         driver.findElement(By.name("assigntype")).click();
		         WebElement group = driver.findElement(By.name("assigned_group_id"));
		         wdu.selectOption(group, 0);
		        

		        Thread.sleep(2000);
		        WebElement LastName = driver.findElement(By.name("lastname"));
		        LastName.sendKeys("Gautam");
		        WebElement Compny = driver.findElement(By.xpath("//input[@name='company']"));
		        Compny.sendKeys("Dxc Technology");
		        WebElement Lead = driver.findElement(By.id("designation"));
		        Lead.sendKeys("Lead");
		        

		        Thread.sleep(2000);
		        WebElement revenu = driver.findElement(By.name("annualrevenue"));
		        revenu.sendKeys("10000");
		        Thread.sleep(2000);
		        WebElement noofemployees = driver.findElement(By.name("noofemployees"));
		        noofemployees.sendKeys("10");
		        Thread.sleep(2000);
		        WebElement secondaryemail= driver.findElement(By.id("secondaryemail"));
		        secondaryemail.sendKeys("opgautam5@gmail.com");
		        Thread.sleep(2000);
		        WebElement phone= driver.findElement(By.id("phone"));
		        phone.sendKeys("6688957452");
		        Thread.sleep(2000);
		        WebElement mobile= driver.findElement(By.id("mobile"));
		        mobile.sendKeys("8565987588");//---mobile
		        Thread.sleep(2000);
		        WebElement fax= driver.findElement(By.id("fax"));
		        fax.sendKeys("651-857-869");//---fax
		        Thread.sleep(2000);
		        WebElement Email= driver.findElement(By.id("email"));
		        Email.sendKeys("opgautam@gmail.com");
		        Thread.sleep(2000);
		        WebElement website = driver.findElement(By.xpath("//input[@style='width:74%;']"));
		        website.sendKeys("sdet.com");
		        
//		        WebElement fname = driver.findElement(By.name("firstname"));
//		        fname.sendKeys("Om",Keys.TAB,Keys.TAB,"Gautam"+JavaUtility.getRandomData(),Keys.TAB,"8565987588",Keys.TAB,"Dxc",Keys.TAB,
//		        "6688957452",Keys.TAB,"Lead",Keys.TAB,"651-857-869");
//		      WebElement email = driver.findElement(By.id("email"));
//		      email.sendKeys("sdet@testyanra",Keys.TAB,Keys.TAB,"dxc.com",Keys.TAB,"1000",Keys.TAB,Keys.TAB,"10",
//		      		Keys.TAB,Keys.TAB,"sdet2@dxc.com");
//		      WebElement title = driver.findElement(By.name("designation"));
//		      title.sendKeys("Dxc",Keys.TAB,"5",Keys.TAB,"ravi@dxc.com");
		        
		        driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[1]")).sendKeys(Description);
		        
		       
		        Thread.sleep(2000);
		        WebElement pobox = driver.findElement(By.id("pobox"));
		        pobox.sendKeys("168 #18");
		        Thread.sleep(2000);
		        WebElement Code = driver.findElement(By.id("code"));
		        Code.sendKeys("301201");
		        Thread.sleep(2000);
		        WebElement City = driver.findElement(By.id("city"));
		        City.sendKeys("Noida");
		        Thread.sleep(2000);
		        WebElement country = driver.findElement(By.id("country"));
		        country.sendKeys("India");
		        Thread.sleep(2000);
		        WebElement State = driver.findElement(By.xpath("//input[@type='text'][@id='state']"));
		        State.sendKeys("Uttar Pradesh");
		        Thread.sleep(2000);
		        //save
		        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		        
		        //Logout
		        Thread.sleep(2000);
		        WebElement mouseOverr = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        wdu.mouseOver(driver, mouseOverr);
		        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		        System.out.println("10th Script Pass");
		        
	}

}
