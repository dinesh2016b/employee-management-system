package com.online.ems.bean;

import java.util.Date;

public class SalariesBean {
	
	private EmployeesBean employeesBean;
	private int salary;
	private Date toDate;
	
	public EmployeesBean getEmployeesBean() {
		return employeesBean;
	}
	public void setEmployeesBean(EmployeesBean employeesBean) {
		this.employeesBean = employeesBean;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
