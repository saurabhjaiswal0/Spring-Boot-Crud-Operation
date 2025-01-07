package com.infosys.spring_boot_simple_crud_operation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.spring_boot_simple_crud_operation.entity.Employee;
import com.infosys.spring_boot_simple_crud_operation.repository.EmployeeRepository;

@Repository
//ye database se communicate kar raha isiliye ise repository annotation se likhunga
public class EmployeeDao {
	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployeeDao(Employee employee) {
	  Employee emp=repository.save(employee);
//	  # Save Method is using ==> new Data is same then data is update And data save
	  return emp;	
	}
	
//	Save Multiple Employee Of the Data base
	public List<Employee> saveMultipleEmployeeDao(List<Employee> employee){
		return repository.saveAll(employee);
	}
	
//	get Employee By id of the Database
	public Employee getEmployeeByIdDao(int empId) {
		Optional<Employee> optional=repository.findById(empId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
			
	}
	
// get All Employee of the Saving in the Database	
	public List<Employee>getAllEmployeeRepositoryDao(){
		List<Employee> employees=repository.findAll();
		return employees;
		
	}
	
//	delete Employee By Id from the Data base
	public boolean deleteEmployeeById(int empid) {
		Employee employee=getEmployeeByIdDao(empid);
		if(employee!=null) {
			repository.deleteById(empid);
			return true;
		}
		else
		{
			return false;
		}
		
	
		
	}

}