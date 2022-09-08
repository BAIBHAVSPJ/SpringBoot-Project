package com.Department.Service.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Department.Service.Entities.Department;
import com.Department.Service.Repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		
		 return departmentRepository.save(department);
		
	}

	public Department findDepartmentById(Long departmentId) {
		
		 Optional<Department> findById = departmentRepository.findById(departmentId);
		 
		 Department department = findById.get();
		 return department;
	}
	
	
	

}
