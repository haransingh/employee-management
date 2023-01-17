package com.fiveExceptions.controller;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.createEmployee(employeeRequest);
    }
}
