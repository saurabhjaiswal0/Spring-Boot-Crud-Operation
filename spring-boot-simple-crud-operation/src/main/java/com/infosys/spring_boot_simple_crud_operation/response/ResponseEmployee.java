package com.infosys.spring_boot_simple_crud_operation.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
//this is a response employee class it is used to define Structure of the response which we send the msg and code
public class ResponseEmployee<T> {
	private int statusCode;
	private String massage;
	private T employeeData;

}
