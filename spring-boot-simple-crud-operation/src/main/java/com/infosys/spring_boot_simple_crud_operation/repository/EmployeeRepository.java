package com.infosys.spring_boot_simple_crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.spring_boot_simple_crud_operation.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
