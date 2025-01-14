package com.tcs.spring.employee.entity;

//import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)// we set "start"and "increment by" value  too in this  use chat-gpt to know about this
	private Long id;
	private String name;
    private String dept;
    private String adress;
    private String college;
    private int age;
    private double salary;
    @Column(name="extramoney")
    private double bouns;
    private double pf;

}
