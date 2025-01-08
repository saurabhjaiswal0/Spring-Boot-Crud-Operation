package com.infosys.spring_boot_simple_crud_operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.infosys.spring_boot_simple_crud_operation.dao.EmployeeDao;
import com.infosys.spring_boot_simple_crud_operation.entity.Employee;
import com.infosys.spring_boot_simple_crud_operation.response.ResponseEmployee;
@Service
public class EmployeeService {
	@Autowired
	private ResponseEmployee<Employee> responseEmployee;
//	This is used for fetch the method of ResponseEmployee
	
	@Autowired
    private EmployeeDao dao;
//	This is used for fetch the method of dao class.
	
	public ResponseEmployee<Employee> getEmployeeById(int empId){
		Employee employee=dao.getEmployeeByIdDao(empId);
		if(employee!=null)
		{
			responseEmployee.setStatusCode(HttpStatus.ACCEPTED.value());
			responseEmployee.setMassage("Data is found Successfully");
			responseEmployee.setEmployeeData(employee);
			return responseEmployee;
		}
		else {
			responseEmployee.setStatusCode(HttpStatus.NO_CONTENT.value());
			responseEmployee.setMassage("Given id is not found");
			responseEmployee.setEmployeeData(employee);
			return responseEmployee;
		}
		
	}
	
}
	
  

