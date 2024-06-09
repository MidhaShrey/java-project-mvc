package com.bean;

public class Customer {
	private long cId;
	private String title;
	private String cName;
	private String cEmail;
	private long cMobile;
	
	public Customer(long cId, String title, String cName, String cEmail, long cMobile)
	{
		super();
		this.cId = cId;
		this.title = title;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cMobile = cMobile;
	}

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public long getcMobile() {
		return cMobile;
	}

	public void setcMobile(long cMobile) {
		this.cMobile = cMobile;
	}
	public Customer() {
		super();
	}
}