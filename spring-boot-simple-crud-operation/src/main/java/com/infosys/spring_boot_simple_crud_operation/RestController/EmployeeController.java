package com.infosys.spring_boot_simple_crud_operation.RestController;

import org.springframework.web.bind.annotation.RestController;

import com.infosys.spring_boot_simple_crud_operation.dao.EmployeeDao;
import com.infosys.spring_boot_simple_crud_operation.entity.Employee;
import com.infosys.spring_boot_simple_crud_operation.response.ResponseEmployee;
import com.infosys.spring_boot_simple_crud_operation.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/saveEmployee")
	public Employee saveEmployeeController(@RequestBody Employee employee) {
		Employee employee2=dao.saveEmployeeDao(employee);
		System.out.println(employee2);
		return employee2;	
	}
	
//	Using of Collection of save the Employee Controller
	@PostMapping(value="/saveMultipleEmployee")
	public List<Employee> saveAllEmployee(@RequestBody List<Employee> employees){
		List<Employee> employee=dao.saveMultipleEmployeeDao(employees);
		return employee;
		
	}
	
// This Method is using for the getEmployeeId
	
	@Operation(
			summary = "This is the getEmployeeById Method",
			description = "In This method if we will pass the id integer then it give us the object of employee",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "if wll get the code 200 means your data is successfull accepted from the data base",
							content=@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Employee.class)
									)
							),
					@ApiResponse(
							responseCode = "500",
							description = "if wll get the code 500 means your data is not found from the databasev ",
							content=@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Employee.class)
									)
							)
			}
			)
	@GetMapping("/getId/{id}") 
	public ResponseEmployee<Employee> getEmployeeById(@PathVariable int id) {
		return  employeeService.getEmployeeById(id);
			
	}
	
//	Get All Employee From The Database.....
	
	@GetMapping(value="/getRepositoryAllEmployee")
	public List<Employee> getAllEmployee() {
		return  dao.getAllEmployeeRepositoryDao();	
		
	}
	
//	Delete The Employee By Id from the DataBase
//	ResponseEntity =>it is a class it is used when we have to give the massage to postman or web browser
	@DeleteMapping(value = "/deleteEmployeeById/{empid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empid) { 
		
		 boolean b=dao.deleteEmployeeById(empid);
		 if(b) {
			 return new ResponseEntity<String>("Data is Deleted",HttpStatus.ACCEPTED);
               //if the code is run then httpStatus.accepted is writen .
		 }
		 else {
			 return new ResponseEntity<String>("Given Id Is not Found",HttpStatus.NOT_FOUND);
		 }
	}
	
//	Delete All Employee whose salary is greater than 50000
	@DeleteMapping(value="/deleteAllEmployeeGreaterThanEqual/{salary}")
	public ResponseEntity<String> deleteAllEmployeeWhoseSalaryGreaterThanEqual(@PathVariable long salary)
	{
		boolean result=dao.deleteEmpWhoseSalaryIsGreaterThanEqual(salary);
		if(result) {
			return new ResponseEntity<String>("Data is Deleted greater than 50000 ",HttpStatus.ACCEPTED);
		}
		else {
			 return new ResponseEntity<String>("No Delete ,salary is less than 50000",HttpStatus.NOT_FOUND);
		}
	}
//	Update Employee salary 5% of current salary
	@PutMapping(value = "/updatedhikesalary/{salary}")
	public ResponseEntity<String> updateHikeSalary(@PathVariable long salary)
	{
		boolean result=dao.updateEmployeeSalaryLessThanEqual(salary);
		if(result) {
			return new ResponseEntity<String>("Data is update with 5% Salary",HttpStatus.ACCEPTED);
 
		}
		else {
			return new ResponseEntity<String>("No Update,Salary is greater than 20000 ",HttpStatus.NOT_FOUND);
		}
		
		
	}
//	######......Pagination And Sorting Concept Program.....######
	
	@GetMapping("/fetchEmployeeByPage/{pageNumber}/{pageSize}")
	public org.springframework.data.domain.Page<Employee> fetchEmployeeByPageNumberAndPageSizeController(@PathVariable int pageNumber,@PathVariable int pageSize){
		return dao.fetchEmployeeByPageNumberAndPageSizeDao(pageNumber, pageSize);
		
	}
	
	@GetMapping(value="/sortingEmpByIdDesc")
	public List<Employee> sortingEmployeeByIdDescController() {
		return  dao.sortingEmployeeByIdDescDao();
			
	}
	
	@GetMapping(value="/fetchEmpByPageNumberAndPageSizeSortOrder/{pageNumber}/{pageSize}/{attribute}")
	public org.springframework.data.domain.Page<Employee> fetchEmployeeByPageNumberAndPageSizeBySortingController(@PathVariable(name = "pageNumber") int pageNumber,@PathVariable(name = "pageSize") int pageSize,@PathVariable(name="attribute") String attribute){
		 return dao.fetchEmployeeByPageNumberAndPageSizeBySortingDao(pageNumber, pageSize, attribute);
	}

	
}
