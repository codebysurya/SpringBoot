package com.tcs.spring.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;


//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.tcs.spring.employee.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	

}
