package PracticePrograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;


public class ReadDatafromPropertiesFile 
{
	@Test
	public void readDataTest() throws Throwable
	{
		//Get the java Object of the Physical file using “FileInputSteam”.
		FileInputStream fis = new FileInputStream("./data/commonData20.properties");
		
		//	Create an Object of “Properties” class & load all the keys.
		Properties pobj = new Properties(); 
		pobj.load(fis);
		
		//Read the data using getProperty(“Key”).
		
		//Note: properties file is light weight & faster in execution compare to Excel
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String TIMEOUT = pobj.getProperty("timeout");
		  
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(TIMEOUT);
		
		
		
	}
	

}
