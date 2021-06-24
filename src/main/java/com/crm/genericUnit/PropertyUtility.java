package com.crm.genericUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Gautam
 *
 */
 
public class PropertyUtility { 
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		Properties ps = new Properties();
		ps.load(fis);
		return ps.getProperty(Key);	
		
	}	

}
	