package com.fiveExceptions.controller;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.service.EmployeeService;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("employees/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Map<String, String> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            employeeService.createEmployee(employeeRequest);
            Map<String, String> response = new HashMap<String, String>();
            response.put("status", "true");
            response.put("message", "success");
            return response;
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        return Collections.emptyMap();
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<EmployeeResponse> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id) {
       return employeeService.updateEmployee(employeeRequest, id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
