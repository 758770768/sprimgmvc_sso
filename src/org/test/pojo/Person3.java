package org.test.pojo;

import java.util.Date;

/**
 * @author Administrator StringToPerson.1创建转换类
 */
public class Person3 {
	private String pname;
	private String psex;
	private String pDate;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsex() {
		return psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	@Override
	public String toString() {
		return "Person3 [pname=" + pname + ", psex=" + psex + ", pDate=" + pDate + ", date=" + date + "]";
	}

}
