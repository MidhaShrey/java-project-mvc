package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUtil {

	public static void main(String[] args) {
		String databaseURL = "jdbc:derby:customerDB; create = true";
		try {
			Connection con = DriverManager.getConnection(databaseURL);
			PreparedStatement pst = null;
			String sql = "Create Table Customer(cId long primary key, title varchar{3), cName varchar(100), cEmail varchar(100), cMobile long)";
//			String sqli = "Drop Table Customer";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			
			pst = con.prepareStatement("Insert into Customer Values(1,`mr`,`abc`,`mr.abc@xyz.com`,1223334444)");
			pst.executeUpdate();
			pst = con.prepareStatement("Insert into Customer Values(2,`ms`,`def`,`ms.def@xyz.com`,6666667777)");
			pst.executeUpdate();
			pst = con.prepareStatement("Insert into Customer Values(3,`mr`,`ghi`,`mr.ghi@xyz.com`,8888888899)");
			pst.executeUpdate();
			System.out.println("Insert Records....");
			
			String sql2 = "Select * from Customer";
			pst = con.prepareStatement(sql2);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) 
			{
				System.out.println(rst.getLong("cId")+":"+rst.getString("title")+":"+rst.getString("cName")+":"+rst.getString("cEmail")+":"+rst.getLong("cMobile"));
			}
			rst.close();
			pst.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}