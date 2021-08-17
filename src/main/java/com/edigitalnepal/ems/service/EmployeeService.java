package com.edigitalnepal.ems.service;

import com.edigitalnepal.ems.exception.DesignationNotFoundException;
import com.edigitalnepal.ems.message.ResponseMessage;
import com.edigitalnepal.ems.model.Employee;
import com.edigitalnepal.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseMessage<?> get(Long id) {
        return ResponseMessage.withResponseData(getEmployee(id), "success");
    }

    public ResponseMessage<?> get(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return ResponseMessage.withResponseData(employees, "success");
    }

    public ResponseMessage<?> save(Employee designation) {
        Employee savedEmployee = employeeRepository.save(designation);
        return ResponseMessage.withResponseData(savedEmployee, "success");
    }

    public ResponseMessage<?> update(Long id, Employee employee) {
        getEmployee(id);
        employee.setId(id);
        return save(employee);
    }

    public ResponseMessage<?> delete(Long id) {
        Employee designation = getEmployee(id);
        employeeRepository.delete(designation);
        return ResponseMessage.withResponseData(null, "success");
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new DesignationNotFoundException(id)
        );
    }
}
