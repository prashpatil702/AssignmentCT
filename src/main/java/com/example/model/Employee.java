package com.example.model;

public class Employee {
	
	private int id;
	private String empName;
	private String deptName;

	public int getId() {
		return id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", deptName=" + deptName + "]";
	}
	
	
	
}
