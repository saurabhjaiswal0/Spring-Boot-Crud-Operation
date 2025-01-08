package com.infosys.spring_boot_simple_crud_operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.spring_boot_simple_crud_operation.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findBySalaryGreaterThanEqual(long salary);
	public List<Employee> findBySalaryLessThanEqual(long salary);
	
	@Query(value="select * from employee order by id desc",nativeQuery = true)
	public List<Employee> sortEmpByIdDesc();
	
	
	

}
