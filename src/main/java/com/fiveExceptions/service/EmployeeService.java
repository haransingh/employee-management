package com.fiveExceptions.service;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .department(employeeRequest.getDepartment())
                .build();
        employeeRepository.save(employee);
        log.info("Employee {} is saved", employee.getId());

    }
}
