package com.fiveExceptions.service;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(this::mapToEmployeeResponse) .toList();
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .build();
    }


}
