package com.test;

import java.util.ArrayList;

import com.bean.Customer;
import com.service.CustomerService;

public class customerTest {
	public static void main(String[] args) throws ClassNotFoundException {
		CustomerService service = new CustomerService();
		ArrayList<Customer> CustomerList = service.getCustomerList();
		System.out.println("=======================[Customers List]=========================");
		for(Customer c: CustomerList)
		{
			System.out.println(c.getcId()+":"+c.getcName()+":"+c.getcEmail());
		}
		
		System.out.println("=======================[Customer Details]=========================");
		Customer c = service.getCustomerDetails(1);
		if (c != null)
		{
			System.out.println(c.getcId()+":"+c.getcName()+":"+c.getcEmail());
		}
		
		System.out.println("=======================[Customer Insertion]=========================");
		Customer c1 = new Customer(2,"ms","abc","abc.ms@xyz.com",1234567890);
		boolean result = service.insertCustomer(c1);
		if(result == true)
		{
			System.out.println("Customer Inserted Successfully!!!");
		}
		else
		{
			System.out.println("Customer Insertion Failed!!!");
		}
		
		System.out.println("=======================[Customer Deletion]=========================");
		result = service.deleteCustomer(1094);
		if(result == true)
		{
			System.out.println("Customer Deleted Successfully!!!");
		}
		else
		{
			System.out.println("Customer Deletion Failed!!!");
		}
		
		System.out.println("=======================[Customer Updation]=========================");
		result = service.updateCustomer(1001, "abc1.ms@xyz2.com");
		if(result == true)
		{
			System.out.println("Customer Updated Successfully!!!");
		}
		else
		{
			System.out.println("Customer Updation Failed!!!");
		}
	}
	
}