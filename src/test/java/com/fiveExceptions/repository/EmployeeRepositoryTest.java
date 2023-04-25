package com.fiveExceptions.repository;

import com.fiveExceptions.entity.Department;
import com.fiveExceptions.entity.Employee;
import com.fiveExceptions.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


import java.util.Optional;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    private static EmployeeRepository employeeRepository;

    @BeforeAll
    public static void setUp() {
        Employee employee = new Employee(null, "Haran", "Singh", "haran.kharte@gmail.com", new Department(1l, "Develpment"), true);
        employeeRepository.save(employee);
    }

    @Test
    public void shouldSaveEmployee() {
        Employee employee = new Employee(null, "Haran", "Singh", "haran.kharte@gmail.com", new Department(1l, "Develpment"), true);
        Employee saveEmployee =  employeeRepository.save(employee);
        assertThat(saveEmployee).usingRecursiveComparison().ignoringFields("id").isEqualTo(employee);
    }

    @Test
    public void shouldReturnSingle() {
        Optional<Employee> employee = employeeRepository.findByEmail("haran.kharte@gmail.com");
        assertThat(employee).isNotEmpty();

    }


}