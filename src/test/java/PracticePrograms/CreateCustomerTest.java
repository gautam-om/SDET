package PracticePrograms;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest {
	
@Test
public void createCustomerTest(XmlTest xml)
{
	System.out.println("execute Test1");
	String USERNAME = xml.getParameter("username");
	 String PASSWORD = xml.getParameter("password");
	 String BROWSER = xml.getParameter("browser");
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
	System.out.println(BROWSER); 
	
//	String USERNAME = System.getProperty("username");
//	String PASSWORD = System.getProperty("pasword");
//	//String BROWSER = System.getProperty("browser");
//	System.out.println("execute Test1");
//	System.out.println("this is execute username " +USERNAME);
//	System.out.println("this is execute pasword " +PASSWORD);
//	//System.out.println("this is execute browser " +BROWSER);
	
}
}
