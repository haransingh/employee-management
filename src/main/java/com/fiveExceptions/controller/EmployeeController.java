package com.fiveExceptions.controller;

import com.fiveExceptions.dto.EmployeeRequest;
import com.fiveExceptions.dto.EmployeeResponse;
import com.fiveExceptions.exception.EmployeeNotFoundException;
import com.fiveExceptions.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployee(id));
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
