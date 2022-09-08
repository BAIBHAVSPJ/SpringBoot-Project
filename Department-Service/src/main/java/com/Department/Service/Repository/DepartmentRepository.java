package com.Department.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Department.Service.Entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	//Department findDepartmentById(Long departmentId);

}
