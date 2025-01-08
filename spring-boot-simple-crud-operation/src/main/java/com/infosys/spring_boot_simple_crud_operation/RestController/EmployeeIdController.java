 package com.infosys.spring_boot_simple_crud_operation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeIdController {

	@GetMapping(value="/getEmployeeById/{id}")
	public int getEmployeeById(@PathVariable int id) {
		System.out.println(id);
		return id;
		
	}
	

}
