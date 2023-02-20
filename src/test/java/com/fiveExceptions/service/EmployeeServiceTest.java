package com.fiveExceptions.service;

import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.entity.Department;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.exception.EmployeeNotFoundException;
import com.fiveExceptions.repository.DepartmentRepository;
import com.fiveExceptions.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private DepartmentRepository departmentRepository;

    private EmployeeService employeeService;

    @BeforeEach
    public void setData() {
        employeeService = new EmployeeService(employeeRepository, departmentRepository);
    }

    @Test
    @DisplayName("Test getEmployee")
    public void shouldReturnTrue() throws EmployeeNotFoundException {
        Department department = new Department(1L, "Development");
        Employee employee = new Employee(123L, "Haran", "Singh", "haran@gmail.com", department, true);
        EmployeeResponse employeeResponseExc = new EmployeeResponse(123L, "Haran", "Singh", "haran@gmail.com", department, true);

        Mockito.when(employeeRepository.findById(123L)).thenReturn(Optional.of(employee));

        EmployeeResponse employeeResponseActual = employeeService.getEmployee(123L);

        Assertions.assertThat(employeeResponseActual.getId()).isEqualTo(employeeResponseExc.getId());
    }

}