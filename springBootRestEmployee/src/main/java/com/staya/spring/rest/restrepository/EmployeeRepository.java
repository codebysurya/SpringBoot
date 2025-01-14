package com.staya.spring.rest.restrepository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.staya.spring.rest.employeeentity.EmployeeEntitty;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntitty, Long> {

	
	public Optional<EmployeeEntitty> findByEmail  (String email);
	
	
	@Query("SELECT e FROM EmployeeEntitty e  WHERE(e.salary > :highsalary AND e.dept= :highdept) OR(e.salary< :lowsalary AND e.dept = :lowdept)")
	List <EmployeeEntitty> findEmployeesWithComplexConditions(
			
			@Param ("highsalary") double highsalary,
			@Param ("highdept") String highdept,
			@Param ("lowsalary") double lowsalary,
			@Param ("lowdept") String lowdept
			
			
			);
	
	@Query("SELECT e FROM EmployeeEntitty e WHERE e.salary BETWEEN :minslary AND :maxslary AND e.dept = :dept ORDER BY e.salary DESC")
	List<EmployeeEntitty> findEmpoyeeBySalaryRangeANDDept(
	        @Param("minslary") double minslary,
	        @Param("maxslary") double maxslary,
	        @Param("dept") String dept
	);


	 boolean existsByEmail(String email); // Custom method to check if an employee exists by email.
	 
	 
        @Transactional
        @Modifying
	    void deleteByEmail(String email); // Custom method to delete an employee by email.


        @Modifying
        @Transactional
        @Query("DELETE FROM EmployeeEntitty e WHERE e.salary BETWEEN :startSalary AND :endSalary")
        int deleteBySalaryRange(@Param("startSalary") double startSalary, @Param("endSalary") double endSalary);
        
        
        
        
        @Modifying
        @Transactional
        void deleteByEmailAndDept(String email, String dept);

	
	
	

}
