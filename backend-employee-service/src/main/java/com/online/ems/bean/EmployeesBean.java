package com.online.ems.bean;

import java.util.List;

import com.online.ems.model.Departments;

public class EmployeesBean {

	private long empNo;
	private String firstName;
	private String lastName;
	private String birthDate;
	
	private List<Departments> departmentList;

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<Departments> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Departments> departmentList) {
		this.departmentList = departmentList;
	}

	@Override
	public String toString() {
		return "EmployeesBean [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + "]";
	}

}