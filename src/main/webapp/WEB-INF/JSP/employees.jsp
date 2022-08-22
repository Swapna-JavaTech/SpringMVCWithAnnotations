<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Employees</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
 <h3>Add/Edit Employee!!!</h3>
 <form:form method="post" action="/springmvcjdbctemplatexample/employees.html" commandName="employee">
 		<div class="table-responsive">
 			<table class="table table-bordered" style="width:300px">
 				<tr>
 					<td>Id :</td>
 					<td><form:input type="text" path="empId" /></td>
 				</tr>
 				<tr>
 					<td>name :</td>
 					<td><form:input type="text" path="empName" /></td>
 				</tr>
 				<tr>
 					<td>salary :</td>
 					<td><form:input type="text" path="empSalary" /></td>
 				</tr>
 				<tr>
 					<td>department :</td>
 					<td><form:input type="text" path="empDeptName" /></td>
 				</tr>
 				<tr>
 					<td></td>
 					<td><input class="btn btn-primary" type="submit" value="Submit" /></td>
 				</tr>
 			</table>
 		</div>
 </form:form>
 <br />
 <br />
 <h3>List of Employees</h3>
 <table class="table table-bordered" style="width:300px">
 	<tr>
 		<th>Employee Id </th>
 		<th>Employee Name </th>
 		<th>Employee Salary </th>
 		<th>Employee Department </th>
 	</tr>
 	<c:forEach items="${employeeList}" var="employee">
 		<tr>
 			<td width="60" align="center">${employee.empId}</td>
 			<td width="60" align="center">${employee.empName}</td>
 			<td width="60" align="center">${employee.empSalary}</td>
 			<td width="60" align="center">${employee.empDeptName}</td>
 			<td width="60" align="center">
 					<a href="edit/${employee.empId}">Edit</a> &nbsp;&nbsp;
 					<a href="delete/${employee.empId}">Delete</a>
 			</td>
 		</tr>
 	</c:forEach>
 </table>
</body>
</html>