package com.staya.spring.rest.employeeentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // This creates the all-args constructor
@NoArgsConstructor   // This creates the no-args constructor
@Entity
public class EmployeeEntitty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private int age;
    private Double salary;
    private String dept;
    

}
