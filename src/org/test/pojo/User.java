package org.test.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class User {

	
	private String uname;
	private String upass;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	
	
	
	
	
	public User() {
		super();
	}
	public User(String uname, String upass,Date bdate) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.bdate=bdate;
	}
	public String getUname(){
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public Date getBdate() {
		return bdate ;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ",upass=" + upass + ", bdate=" + bdate  + "]";
	}
 
 
	
}
