package com.fiveExceptions.service;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.entity.Department;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.exception.EmployeeNotFoundException;
import com.fiveExceptions.repository.DepartmentRepository;
import com.fiveExceptions.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class EmployeeService {

   // private static final Logger log =  LogManager.getLogger(EmployeeService.class);


    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        log.info("createEmployee employee");
        Department department = departmentRepository.findById(employeeRequest.getDepartmentId()).orElse(null);
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .department(department)
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
        Optional<Department> department = departmentRepository.findById(1L);

        //List<Employee> employees = employeeRepository.findActiveEmployees(false, department);
        List<Employee> employees = employeeRepository.findByStatusIsFalse();

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


    public EmployeeResponse getEmployee(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        System.out.println("employee isEmpty " + employee.isEmpty());
        System.out.println("employee isPresent " + employee.isPresent());

        if (employee.isPresent()) {

        } else {
            throw new EmployeeNotFoundException("Employee not found with id " + id);
        }
        return employee.map(value -> EmployeeResponse.builder()
                .id(value.getId())
                .firstName(value.getFirstName())
                .lastName(value.getLastName())
                .email(value.getEmail())
                .department(value.getDepartment())
                .build()).orElse(null);
    }

    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {
        Department department = departmentRepository.findById(employeeRequest.getDepartmentId()).orElse(null);
        employeeRepository.findById(id).map(employee -> {
            employee.setFirstName(employeeRequest.getFirstName());
            employee.setLastName((employeeRequest.getLastName()));
            employee.setEmail(employeeRequest.getEmail());
            employee.setDepartment(department);
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
