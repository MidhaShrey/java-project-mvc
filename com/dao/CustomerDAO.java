package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;

public class CustomerDAO {
	public ArrayList<Customer> getCustomerList() throws ClassNotFoundException{
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	try {
//		1. Initialize the Driver
//		Class.forName("com.jdbc.oracle.oracleDriver");
//		2. Establish the Connection with the DB
		Connection con = DriverManager.getConnection("jdbc:derby:customerDB; create = true");
//		3. Create a PreparedStatement Object to mention the SQL to execute
		PreparedStatement pst = con.prepareStatement("Select * from Customer");
//		4. Execute the query and store the result in a ResultSet
		ResultSet rst = pst.executeQuery();
//		5. Initialize the ResultSet and prepare the business object
		while(rst.next()) {
			long cId = rst.getInt("cId");
			String cTitle = rst.getString("cTitle");
			String cName = rst.getString("cName");
			String cEmail = rst.getString("cEmail");
			long cMobile = rst.getLong("cMobile");
			Customer custom = new Customer(cId, cTitle, cName, cEmail, cMobile);
			customerList.add(custom);
//		6. Close the connection
			pst.close();
			rst.close();
			con.close();
			}
		}catch(SQLException e)
		{
		System.out.println(e.getMessage());
		}
		return customerList;
	}
	
	
	public Customer getCustomerDetails(int cId) throws ClassNotFoundException
	{
		Customer result = null;
		try {
//			1. Initialize the Driver
//			Class.forName("com.jdbc.oracle.oracleDriver");
//			2. Establish the Connection with the DB
			Connection con = DriverManager.getConnection("jdbc:derby:customerDB; create = true");
//			3. Create a PreparedStatement Object to mention the SQL to execute
			PreparedStatement pst = con.prepareStatement("Select * from Customer where cId = ?");
			pst.setInt(1, cId);
//			4. Execute the query and store the result in a ResultSet
			ResultSet rst = pst.executeQuery();
//			5. Initialize the ResultSet and prepare the business object
			while(rst.next()) {
				long cId1 = rst.getInt("cId");
				String cTitle = rst.getString("cTitle");
				String cName = rst.getString("cName");
				String cEmail = rst.getString("cEmail");
				long cMobile = rst.getLong("cMobile");
				result = new Customer(cId1, cTitle, cName,cEmail, cMobile);
//			6. Close the connection
				pst.close();
				rst.close();
				con.close();
				}
			}catch(SQLException e)
			{
			System.out.println(e.getMessage());
			}
			return result;
		}
	
	
	public boolean insertCustomer(Customer c) throws ClassNotFoundException
	{
		boolean result = false;
		try {
//			1. Initialize the Driver
//			Class.forName("com.jdbc.oracle.oracleDriver");
//			2. Establish the Connection with the DB
			Connection con = DriverManager.getConnection("jdbc:derby:customerDB; create = true");
//			3. Create a PreparedStatement Object to mention the SQL to execute
			PreparedStatement pst = con.prepareStatement("Insert into Customer values (?,?,?,?,?)");
			pst.setLong(1, c.getcId());
			pst.setString(2, c.getTitle());
			pst.setString(3, c.getcName());
			pst.setString(4, c.getcEmail());
			pst.setLong(5, c.getcMobile());
//			4. Execute the query and store the result in a ResultSet
			int t = pst.executeUpdate();
			if (t > 0) 
				{
					result = true;
				}
//			5. Close the connection
				pst.close();
				con.close();
			}catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			return result;
	}
	
	public boolean deleteCustomer(int cId) throws ClassNotFoundException
	{
		boolean result = false;
		try {
//			1. Initialize the Driver
//			Class.forName("com.jdbc.oracle.oracleDriver");
//			2. Establish the Connection with the DB
			Connection con = DriverManager.getConnection("jdbc:derby:customerDB; create = true");
//			3. Create a PreparedStatement Object to mention the SQL to execute
			PreparedStatement pst = con.prepareStatement("Delete from Customer where cId = ?");
			pst.setLong(1, cId);
//			4. Execute the query and store the result in a ResultSet
			int t = pst.executeUpdate();
			if (t > 0) 
				{
					result = true;
				}
//			5. Close the connection
				pst.close();
				con.close();
			}catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			return result;
	}
	
	
	public boolean updateCustomer(long cId, String cEmail) throws ClassNotFoundException
	{
		boolean result = false;
		try {
//			1. Initialize the Driver
//			Class.forName("com.jdbc.oracle.oracleDriver");
//			2. Establish the Connection with the DB
			Connection con = DriverManager.getConnection("jdbc:derby:customerDB; create = true");
//			3. Create a PreparedStatement Object to mention the SQL to execute
			PreparedStatement pst = con.prepareStatement("Update Customer set cEmail = ? where cId = ?");
			pst.setString(1, cEmail);
			pst.setLong(2, cId);
//			4. Execute the query and store the result in a ResultSet
			int t = pst.executeUpdate();
			if (t > 0) 
				{
					result = true;
				}
//			5. Close the connection
				pst.close();
				con.close();
			}catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			return result;
	}
}