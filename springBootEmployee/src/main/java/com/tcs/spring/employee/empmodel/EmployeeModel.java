package com.tcs.spring.employee.empmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	
       private String name;
       private String dept;
       private String adress;
       private String college;
       private int age;
       private double salary;
//       private 

}