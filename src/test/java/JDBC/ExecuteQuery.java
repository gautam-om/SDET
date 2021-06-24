package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {
	
	@Test
	 public void executeQuery() throws SQLException
	 {
//	  //Step 1:Register to database
//	  Driver driverref=new Driver();
//	  DriverManager.registerDriver(driverref);
//	  //Step 2:establish connection with database
//	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
//	  //Step 3: Issue create statement
//	  Statement stat = con.createStatement();
//	  //Step 4:Execute any query
//	  ResultSet result = stat.executeQuery("select * from customer;");
//	  while(result.next())
//	  {
//	   System.out.println(result.getString(1));
//	  }
//	  //Step 5:Close database connection
//	  con.close();
		
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" , "root", "root");
		Statement stat = con.createStatement();
		
	     ResultSet result = stat.executeQuery("select * from project;");
		
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
		
		con.close();
		
		
		


}
}
