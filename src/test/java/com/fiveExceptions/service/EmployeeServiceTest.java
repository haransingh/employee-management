package com.fiveExceptions.service;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.entity.Department;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.exception.EmployeeNotFoundException;
import com.fiveExceptions.repository.DepartmentRepository;
import com.fiveExceptions.repository.EmployeeRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private DepartmentRepository departmentRepository;

    @Captor
    private ArgumentCaptor<Employee> postArgumentCaptor;

    @MockBean
    private EmployeeService employeeService;

    private Department department;
    private Employee employee;

    @BeforeEach
    public void setData() {
        employeeService = new EmployeeService(employeeRepository, departmentRepository);
        department = new Department(1L, "Development");
        employee = new Employee(123L, "Haran", "Singh", "haran@gmail.com", department, true);

    }

    @Test
    @DisplayName("Test getEmployee")
    public void shouldReturnTrue() throws EmployeeNotFoundException {
        EmployeeResponse employeeResponseExc = new EmployeeResponse(123L, "Haran", "Singh", "haran@gmail.com", department, true);
        Mockito.when(employeeRepository.findById(123L)).thenReturn(Optional.of(employee));
        EmployeeResponse employeeResponseActual = employeeService.getEmployee(123L);
        Assertions.assertThat(employeeResponseActual.getId()).isEqualTo(employeeResponseExc.getId());
    }

    @Test
    public void shouldSaveEmployee() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        EmployeeRequest employeeRequest = new EmployeeRequest("Haran", "Singh", "haran@gmail.com", 1L);
        EmployeeResponse actual = employeeService.createEmployee(employeeRequest);
        Mockito.verify(employeeRepository, Mockito.times(1)).save(postArgumentCaptor.capture());
    }


}