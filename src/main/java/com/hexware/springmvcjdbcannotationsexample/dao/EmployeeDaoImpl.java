package com.hexware.springmvcjdbcannotationsexample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.hexware.springmvcjdbcannotationsexample.model.Employee;


public class EmployeeDaoImpl implements EmployeeDao {

	/*
	 * A factory for connections to the physical data source 
	 * that this DataSource object represents. An alternative to 
	 * the DriverManager facility, a DataSource objectis the 
	 * preferred means of getting a connection. 
	 * An object that implements the DataSource interface 
	 * will typically beregistered with a 
	 * naming service based on theJava™ Naming and Directory (JNDI) API
	 */
	
	
	private JdbcTemplate jdbcTemplate;
	
	//Autowiring using setter method

	
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}





	@Override
	public void insertEmployee(Employee emp) {
		
		String insertEmp = "insert into Employee values(?,?,?,?)";
		
		jdbcTemplate.update(insertEmp,new Object[] {
				emp.getEmpId(),emp.getEmpName(),emp.getEmpSalary(),
				emp.getEmpDeptName()
		});
		
	}





	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Employee> getAllEmployees() {
		String getEmpList = "select * from employee";
		
		List<Employee> empList = jdbcTemplate.query(getEmpList, new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> eList = new ArrayList<Employee>();
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmpId(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setEmpSalary(rs.getFloat(3));
					emp.setEmpDeptName(rs.getString(4));
					eList.add(emp);
				}
				return eList;
			}
			
		});
		return empList;
	}





	@Override
	public void deleteEmployee(int id) {
		String deleteEmp = "delete from employee where employeeid=?";
		jdbcTemplate.update(deleteEmp,new Object[] {id});
	}





	@Override
	public Employee getEmployeeById(int empid) {
		String getEmp = "select * from employee where employeeid=?";
		Employee employee = jdbcTemplate.queryForObject(getEmp, new Object[] {empid}
		,new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpSalary(rs.getFloat(3));
				emp.setEmpDeptName(rs.getString(4));
				return emp;
			}
			
		});
		return employee;
	}
	
	//Updating particular employee
	public void updateEmployee(Employee emp) {
		String updateEmp = "update employee set employeename=?,employeesalary=?,employeedeptname=? where employeeid=?";
		jdbcTemplate.update(updateEmp,new Object[] {
			emp.getEmpName(),emp.getEmpSalary(),emp.getEmpSalary(),emp.getEmpId()
		});
	
	}

}
