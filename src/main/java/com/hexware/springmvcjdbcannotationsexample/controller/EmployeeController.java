package com.hexware.springmvcjdbcannotationsexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hexware.springmvcjdbcannotationsexample.dao.EmployeeDao;
import com.hexware.springmvcjdbcannotationsexample.model.Employee;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao empDao;
	
	@RequestMapping(value = "/employees",method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
		try {
			if(empDao.getEmployeeById(employee.getEmpId())!=null)
			System.out.println(employee);
			empDao.updateEmployee(employee);
		} catch (EmptyResultDataAccessException e) {
			empDao.insertEmployee(employee);
		}
		return new ModelAndView("redirect:/employees");
	}

	@RequestMapping(value = "/employees")
	public ModelAndView getAllEmployees(@ModelAttribute("employee") Employee employee){
		ModelAndView model = new ModelAndView("employees");
		List<Employee> employeeList = empDao.getAllEmployees();
		System.out.println(employeeList);
		model.addObject("employeeList",employeeList );
		return model;
	}
	
	@RequestMapping(value = "/delete/{eid}")
	public ModelAndView  deleteEmployee(@ModelAttribute("employee") Employee employee,
		@PathVariable("eid") int empid) {
		empDao.deleteEmployee(empid);
			return new ModelAndView("redirect:/employees");
		
	}
	
	@RequestMapping(value = "/edit/{eid}")
	public ModelAndView  editEmployee(@ModelAttribute("employee") Employee employee,
		@PathVariable("eid") int empid) {
		ModelAndView model = new ModelAndView("employees");
		employee = empDao.getEmployeeById(empid);
		List<Employee> employeeList = empDao.getAllEmployees();
		model.addObject("employee",employee);
		//System.out.println(employeeList);
		model.addObject("employeeList",employeeList );
			return new ModelAndView("redirect:/employees");
		
	}
}
 