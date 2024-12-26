package com.tcs.spring.employee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.spring.employee.empmodel.EmployeeModel;
import com.tcs.spring.employee.entity.EmployeeEntity;
import com.tcs.spring.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/empform")
	public String getter() {
		return "EmployeeForm";
	}
	
	
	@PostMapping("/empformsaved")
	public String put(EmployeeModel employeemodel) {
		
		System.out.println(employeemodel);
		
		employeeService.svaeEmployeeDetails(employeemodel);
		
		return "savedempsuccess";
	}
	
	
	@GetMapping("/saveEmpDetails")
	public String saveEmpDetails(Model model) {
		
		
		List<EmployeeEntity> Empolyee=employeeService.saveEmpDetails();
		
		
		model.addAttribute("employees",Empolyee);
				
		
		return "EmpSaved";
		
		}
	
	
	
	
	@GetMapping("/search")
	public String searchById() {
		
		return "Employee-search";
		
	}
	
	
	@PostMapping("/searchById")
	public String searchById(@RequestParam Long id,Model model) {
		
		EmployeeEntity employeeEntity= employeeService.serachById(id);
		
		model.addAttribute("employeeEntity", employeeEntity);
		
		
		return "Employee-search";
	}
	
	
     @GetMapping("/delete/{id}")
     public String deleteEmpById(@PathVariable ("id") Long id) {
    	 
    	 employeeService.deleteEmpById(id);
    	 
    	 return "redirect:/saveEmpDetails";
    	 
     }







}
















