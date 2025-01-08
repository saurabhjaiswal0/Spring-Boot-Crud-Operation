package com.infosys.spring_boot_simple_crud_operation.entity;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Schema(description = "Employee-details")
// pojo class 
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @Schema(description ="You Should not pass the duplicate value and id should be integer only ,example-12345")
	private int id;
	private String name;
	private String email;
	private long salary;

}
