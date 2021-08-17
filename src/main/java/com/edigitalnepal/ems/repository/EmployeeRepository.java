package com.edigitalnepal.ems.repository;

import com.edigitalnepal.ems.model.Designation;
import com.edigitalnepal.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
