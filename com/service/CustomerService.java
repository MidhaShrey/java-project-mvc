package com.service;

import com.bean.Customer;
import com.dao.CustomerDAO;
import java.util.ArrayList;

public class CustomerService {
//	for Business Logic
		CustomerDAO dao = new CustomerDAO();
	public ArrayList<Customer> getCustomerList() throws ClassNotFoundException {
		return dao.getCustomerList();
	}
	public Customer getCustomerDetails(int cId) throws ClassNotFoundException {
		return dao.getCustomerDetails(cId);
	}
	public boolean insertCustomer(Customer c) throws ClassNotFoundException {
		return dao.insertCustomer(c);
	}
	public boolean deleteCustomer(int cId) throws ClassNotFoundException {
		return dao.deleteCustomer(cId);
	}
	public boolean updateCustomer(int cId, String newEmail) throws ClassNotFoundException {
		return dao.updateCustomer(cId, newEmail);
	}
}