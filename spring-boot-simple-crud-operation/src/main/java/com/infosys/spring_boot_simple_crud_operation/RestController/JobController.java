package com.infosys.spring_boot_simple_crud_operation.RestController;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class JobController {
//	if the using of requestmapping the decleare the method type
	@RequestMapping(value = "/getTodayDate",method = RequestMethod.GET)
	public String getTodayDate() {
		return LocalDate.now()+" ";
		
	}

}
