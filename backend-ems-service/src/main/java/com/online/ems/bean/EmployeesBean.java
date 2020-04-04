package com.online.ems.bean;

import java.util.List;

public class EmployeesBean {

	private long empNo;
	private String firstName;
	private String lastName;
	private String birthDate;
	
	private List<DepartmentsBean> departmentsBeanList;

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

	public List<DepartmentsBean> getDepartmentsBeanList() {
		return departmentsBeanList;
	}

	public void setDepartmentsBeanList(List<DepartmentsBean> departmentsBeanList) {
		this.departmentsBeanList = departmentsBeanList;
	}

	@Override
	public String toString() {
		return "EmployeesBean [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + "]";
	}

}