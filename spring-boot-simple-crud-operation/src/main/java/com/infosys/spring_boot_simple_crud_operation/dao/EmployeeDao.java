package com.infosys.spring_boot_simple_crud_operation.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.infosys.spring_boot_simple_crud_operation.entity.Employee;
import com.infosys.spring_boot_simple_crud_operation.repository.EmployeeRepository;
import com.infosys.spring_boot_simple_crud_operation.response.ResponseEmployee;


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
	
// find All Employee of the Saving in the Database	
	public List<Employee>getAllEmployeeRepositoryDao(){
		List<Employee> employees=repository.findAll();
		return employees;
		
	}
//	get all employee whose salary is greater than and equal to 50000
	public List<Employee> findEmpWhoseSalaryIsgreterthanequal(long salary){
		return repository.findBySalaryGreaterThanEqual(salary);
		
	}
//  delete All Employee whose Salary is greater Than 50000
	public boolean deleteEmpWhoseSalaryIsGreaterThanEqual(long salary) {
		 List<Employee> employees=findEmpWhoseSalaryIsgreterthanequal(salary);
		 if(!employees.isEmpty())
		 {
			 repository.deleteAll(employees);
			 return true;
		 }
		 else {
			 return false;
		 }
					 
	}
	
//	find all Employee whose salary is less than equal to 20000
	public List<Employee> findEmpWhoseSalaryLessThanEqual(long salary){
		return repository.findBySalaryLessThanEqual(salary);
	}
	
//	hike salary 5% whose Employee Salary is less than 20000
	public boolean updateEmployeeSalaryLessThanEqual(long salary)
	{
		List<Employee> employees=findEmpWhoseSalaryLessThanEqual(salary);
		if(employees!=null) {
			for (Employee employee : employees) {
				long currentSal=employee.getSalary();
				long newSal=(long) (currentSal+(currentSal*(5.0/100.0)));
				employee.setSalary(newSal);
				repository.save(employee);
				
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
//	delete Employee By Id from the Data base
	public boolean deleteEmployeeById(int empId) {
		Employee employee=getEmployeeByIdDao(empId);
		if(employee!=null) {
			repository.deleteById(empId);
			return true;
		}
		else
		{
			return false;
		}
			
	}
	public List<Employee> sortingEmployeeByIdDescDao() {
		return  repository.sortEmpByIdDesc();
			
	}
	
//	Using of this method multiple page is fetch of the pagination concept  from pageNumber and pageSize
	public org.springframework.data.domain.Page<Employee> fetchEmployeeByPageNumberAndPageSizeDao(int pageNumber,int pageSize){
		return repository.findAll(PageRequest.of(pageNumber, pageSize));
		
	}
   
//	
	public org.springframework.data.domain.Page<Employee> fetchEmployeeByPageNumberAndPageSizeBySortingDao(int pageNumber,int pageSize,String attribute){
		 return repository.findAll(PageRequest.of(pageNumber, pageSize, org.springframework.data.domain.Sort.Direction.DESC, attribute));
	}

}