package com.staya.spring.rest.restservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staya.spring.rest.employeeentity.EmployeeEntitty;
import com.staya.spring.rest.restrepository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeEntitty saveEmployee(EmployeeEntitty employee) {
		return employeeRepository.save(employee);
		
	}
	
	
	
public List<EmployeeEntitty> saveAllEmployee(List<EmployeeEntitty> employeeEntitty) {
	
	return employeeRepository.saveAll(employeeEntitty);
	
	
		
		
	}





	public List<EmployeeEntitty> getAllEmp() {
		
		return employeeRepository.findAll();
		
	}

	public Optional<EmployeeEntitty> getEmpById(Long id) {
		
		return employeeRepository.findById(id);
		
		
	}
	
//	public Optional <EmployeeEntitty> getEmployeeById(Long id) {
//		Optional <EmployeeEntitty> emp=employeeRepository.findById(id);
//		return emp;
//		
//	}
	
	
	public Optional <EmployeeEntitty> getEmployeeByEmail(String email) {
		Optional <EmployeeEntitty> emp=employeeRepository.findByEmail(email);
		return emp;
		
	}

	public List<EmployeeEntitty> getEmpComplexConditions(double highsalary, String highdept, double lowsalary,
			String lowdept) {
		
		return employeeRepository.findEmployeesWithComplexConditions(highsalary, highdept, lowsalary, lowdept);
	}

	public List<EmployeeEntitty> findEmployeesBySalaryRangeAndDept(double minSalary, double maxSalary, String dept) {
		
		return  employeeRepository.findEmpoyeeBySalaryRangeANDDept(minSalary, maxSalary, dept);
	}



	public boolean dleteEmployeeById(Long id) {
		
		
		if(employeeRepository.existsById(id)) {
			
			employeeRepository.deleteById(id);
			
			return true;
			
		}
		else {
			return false;
		}
		
	}



	public boolean deleteEmployeeByEmail(String email) {
        if (employeeRepository.existsByEmail(email)) {
            employeeRepository.deleteByEmail(email);
            return true;
        } else {
            return false;
        }
    }



	public boolean deleteBySalaryRange(double startsalary, double endsalary) {
	    int deletedCount = employeeRepository.deleteBySalaryRange(startsalary, endsalary);
	    return deletedCount > 0; // Return true if records were deleted
	}

	
	public boolean deleteByEmailAndDept(String email, String dept) {
        employeeRepository.deleteByEmailAndDept(email, dept);
        return true;
    }



	public EmployeeEntitty updateEmployee(Long id, EmployeeEntitty newEmployee) {
		
		
		employeeRepository.findById(id);
		  Optional<EmployeeEntitty> optionalEmployee = employeeRepository.findById(id);

	        if (optionalEmployee.isPresent()) {
	            EmployeeEntitty existingEmployee = optionalEmployee.get();
	            existingEmployee.setName(newEmployee.getName());
	            existingEmployee.setEmail(newEmployee.getEmail());
	            existingEmployee.setAge(newEmployee.getAge());              // if these
	            existingEmployee.setSalary(newEmployee.getSalary());
	            existingEmployee.setDept(newEmployee.getDept());
	            
	            // Update other fields as necessary
	            return employeeRepository.save(existingEmployee);
	        }
			return null;
		
	}
	
	

	

}
