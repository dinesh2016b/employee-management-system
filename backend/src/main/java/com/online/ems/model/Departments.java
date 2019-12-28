package com.online.ems.model;
// Generated Aug 11, 2019 12:49:44 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Departments generated by hbm2java
 */
@Entity
@Table(name = "departments", catalog = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "dept_name"))
public class Departments implements java.io.Serializable {

	private String deptNo;
	private String deptName;
	private Set<DeptEmp> deptEmps = new HashSet<DeptEmp>(0);
	private Set<DeptManager> deptManagers = new HashSet<DeptManager>(0);

	public Departments() {
	}

	public Departments(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public Departments(String deptNo, String deptName, Set<DeptEmp> deptEmps, Set<DeptManager> deptManagers) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptEmps = deptEmps;
		this.deptManagers = deptManagers;
	}

	@Id

	@Column(name = "dept_no", unique = true, nullable = false, length = 4)
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "dept_name", unique = true, nullable = false, length = 40)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
	public Set<DeptEmp> getDeptEmps() {
		return this.deptEmps;
	}

	public void setDeptEmps(Set<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
	public Set<DeptManager> getDeptManagers() {
		return this.deptManagers;
	}

	public void setDeptManagers(Set<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

}
