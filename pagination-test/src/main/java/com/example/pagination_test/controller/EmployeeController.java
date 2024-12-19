package com.example.pagination_test.controller;

import com.example.pagination_test.model.Employee;
import com.example.pagination_test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("employees")
    public void save() {
        employeeService.create();
    }

}
