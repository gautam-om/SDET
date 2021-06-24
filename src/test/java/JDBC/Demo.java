package JDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Demo {
	@Test
	 public void executeQuery() throws SQLException
	 {
	  Connection con=null;
	  try{
	  //Step 1:Register to database
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  //Step 2:establish connection with database
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	  //Step 3: Issue create statement
	  Statement stat = con.createStatement();
	  //Step 4:Execute any query
	  int result = stat.executeUpdate("insert into  valuse(3,'OM','Gautam','noida');");
	  if(result==1)
	  {
	   System.out.println("customer is successfully created");
	  }
	  else
	  { 
	   System.out.println("Query failed");
	  }
	  }
	  catch(Exception e){
	  }
	  finally{
	  //Step 5:Close database connection
	  con.close();
	  System.out.println("database connection is closed");
	  }
	 } 


}
