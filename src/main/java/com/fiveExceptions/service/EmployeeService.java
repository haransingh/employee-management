package com.fiveExceptions.service;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .department(employeeRequest.getDepartment())
                .build();
        employeeRepository.save(employee);

        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .department(employee.getDepartment())
                .build();
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


    public EmployeeResponse getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(value -> EmployeeResponse.builder()
                .id(value.getId())
                .firstName(value.getFirstName())
                .lastName(value.getLastName())
                .email(value.getEmail())
                .department(value.getDepartment())
                .build()).orElse(null);
    }

    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {
        employeeRepository.findById(id).map(employee -> {
            employee.setFirstName(employeeRequest.getFirstName());
            employee.setLastName((employeeRequest.getLastName()));
            employee.setEmail(employeeRequest.getEmail());
            employee.setDepartment(employeeRequest.getDepartment());
            employeeRepository.save(employee);
            return EmployeeResponse
                    .builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .email(employee.getEmail())
                    .department(employee.getDepartment())
                    .build();
        });
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
