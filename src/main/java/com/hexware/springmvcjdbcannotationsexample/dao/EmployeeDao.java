package com.hexware.springmvcjdbcannotationsexample.dao;

import java.util.List;

import com.hexware.springmvcjdbcannotationsexample.model.Employee;



public interface EmployeeDao {
	
	public void insertEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int id);
	public Employee getEmployeeById(int empid);
	public void updateEmployee(Employee emp);
}
