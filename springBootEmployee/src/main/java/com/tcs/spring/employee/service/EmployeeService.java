package com.tcs.spring.employee.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.spring.employee.empmodel.EmployeeModel;
import com.tcs.spring.employee.entity.EmployeeEntity;
import com.tcs.spring.employee.repository.EmployeeRepository;
//import com.tcs.spring.entity.ProductEntity;


@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeerepository;
	
	public void svaeEmployeeDetails(EmployeeModel employeeModel) {
		
		double bonus;
		bonus=employeeModel.getSalary()*10;
		double pf;
		pf=employeeModel.getAge()*(employeeModel.getSalary()*0.05);
		
		
		EmployeeEntity employeeEntity=new EmployeeEntity();
		
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setDept(employeeModel.getDept());
		employeeEntity.setAdress(employeeModel.getAdress());
		employeeEntity.setCollege(employeeModel.getCollege());
		employeeEntity.setAge(employeeModel.getAge());
		employeeEntity.setSalary(employeeModel.getSalary());
		employeeEntity.setBouns(bonus);
		employeeEntity.setPf(pf);
		employeerepository.save(employeeEntity);
		
		
		}
	
	
	
	
	
	public List<EmployeeEntity> saveEmpDetails(){
		
		List<EmployeeEntity> emps=employeerepository.findAll();
		
		return emps;
		
	}

	public EmployeeEntity serachById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<EmployeeEntity> optionalData=employeerepository.findById(id);
		
		if(optionalData.isPresent()) {
			
			EmployeeEntity employeeEntity=optionalData.get();
			
			return employeeEntity ;
			
			
		}
		
		else {
			return null;
		}
		
		
	}
	
	
	
}
