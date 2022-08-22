package com.hexware.springmvcjdbcannotationsexample.model;

public class Employee {
	
	private int empId;
	private String empName;
	private float empSalary;
	private String empDeptName;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, float empSalary, String empDeptName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDeptName = empDeptName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDeptName() {
		return empDeptName;
	}

	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empDeptName="
				+ empDeptName + "]";
	}
	
	
	

}
