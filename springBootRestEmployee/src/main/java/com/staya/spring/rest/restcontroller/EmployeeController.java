package com.staya.spring.rest.restcontroller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staya.spring.rest.employeeentity.EmployeeEntitty;
import com.staya.spring.rest.errorresponse.ErrorResponse;
import com.staya.spring.rest.restservice.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveemployee")
	public ResponseEntity<EmployeeEntitty> saveEmployee(@RequestBody EmployeeEntitty employee){
		
		
		EmployeeEntitty emp=employeeService.saveEmployee(employee);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info", "data save success")
				             .body(emp);
		
	}
	
	
	@PostMapping("/saveallemployee")
	public ResponseEntity<List<EmployeeEntitty>> saveAllEmployee(@RequestBody List<EmployeeEntitty> employeeEntitty){
		  
		
		List<EmployeeEntitty> emps=employeeService.saveAllEmployee(employeeEntitty);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info","data saved surya")
				             .body(emps);
		
		              
	}
	
	
	@GetMapping("/getallemployee")
	public ResponseEntity<List<EmployeeEntitty>> getAllEmp(){
		List<EmployeeEntitty> emp= employeeService.getAllEmp();
		
		return ResponseEntity.status(HttpStatus.OK)
				             .header("info", "success surya")
				             .body(emp);
	}
	
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<EmployeeEntitty> getEmpById(@PathVariable ("id") Long id){
		   Optional<EmployeeEntitty> emp= employeeService.getEmpById(id);
		   
		   if(emp.isPresent()) {
			   
			   
			   return ResponseEntity.status(HttpStatus.OK)
					                .header("info", "data retrived")
					                .body(emp.get());
		   }
		   
		   else {
			   
			   return ResponseEntity.notFound().build();
			   
		   }
		   		    
	}
	
	
//	
////	Get employee details by id
//	@GetMapping("/getemployee/{id}")
//	public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
//		Optional <EmployeeEntitty> getEmp=employeeService.getEmployeeById(id);
//		if(getEmp.isPresent())
//		{
//			
//		return ResponseEntity.status(HttpStatus.OK)
//							.header("info", "Data retrivede successfully")
//							.body(getEmp);
//		}
//		else {
//			ErrorResponse errorResponse=new ErrorResponse();
//			errorResponse.setStatuscode(HttpStatus.NOT_FOUND.value());          THIS ONE HERE IS SEND CUSTOME ERROR RESPOSE FOR REAL TIME USE
//			errorResponse.setMessage("Data not found with given ID"+id);
//			errorResponse.setTimestamp(LocalDateTime.now());
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.header("info", "Data retrivede successfully")
//					.body(errorResponse);
//			}
//		}
	
	
	
//	Get employee details by Email
	@GetMapping("/getemployee/email/{email}")
	public ResponseEntity<?> getEmployeeByEmail(@PathVariable String email) {
		Optional <EmployeeEntitty> getEmp=employeeService.getEmployeeByEmail(email);
		if(getEmp.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
					.header("info", "Data retrivede successfully")
					.body(getEmp.get());
		}
		else {
			ErrorResponse apiResponse=new ErrorResponse();
			apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiResponse.setMessage("Data not found with given Email "+email);
			apiResponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.header("info", "Data retrivede successfully")
					.body(apiResponse);
			}
	}
	
	
	
	@GetMapping("/getempcomplexconditions")
	public ResponseEntity<List<EmployeeEntitty>> getEmpComplexConditions(
			  @RequestParam("highsalary") double highsalary,
	            @RequestParam("highdept") String highdept,
	            @RequestParam("lowsalary") double lowsalary,
	            @RequestParam("lowdept") String lowdept) {
		
		List<EmployeeEntitty> emps=employeeService.getEmpComplexConditions(highsalary, highdept, lowsalary, lowdept);
		
		
		return ResponseEntity.status(HttpStatus.OK)
				             .header("info", "Data retrivede successfully")
				             .body(emps);
	}
	
	
	
	
	@GetMapping("/findBySalaryAndDept")
    public ResponseEntity<List<EmployeeEntitty>> findEmployeesBySalaryRangeAndDept(
            @RequestParam("minsalary") double minSalary,
            @RequestParam("maxsalary") double maxSalary,
            @RequestParam("dept") String dept) {
        
		List<EmployeeEntitty> emps= employeeService.findEmployeesBySalaryRangeAndDept(minSalary, maxSalary, dept);
         
         return ResponseEntity.status(HttpStatus.OK)
        		              .header("info", "done done")
        		              .body(emps);
    }
	
	

}
