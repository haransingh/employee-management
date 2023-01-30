package com.fiveExceptions.controller;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            return employeeService.createEmployee(employeeRequest);
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return null;
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EmployeeResponse> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id) {
       return employeeService.updateEmployee(employeeRequest, id);
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
