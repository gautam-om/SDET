package com.crm.genericUnit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 * 		
 * @author Gautam
 *
 */
public class JsonDataUtility {
	
	public String readDataFromJSON(String key) throws Throwable
	{
		FileReader inputFile= new FileReader(IPathConstant.JSONFILEPATH);
		
		//parse the json object into java
		JSONParser parser=new JSONParser();
		Object object = parser.parse(inputFile); 
		
		HashMap jobject=(HashMap)object;
		String value = jobject.get(key).toString();
		return value;
	}

}
