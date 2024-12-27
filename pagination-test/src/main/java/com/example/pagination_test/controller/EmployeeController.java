package com.example.pagination_test.controller;

import com.example.pagination_test.model.Employee;
import com.example.pagination_test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@AllArgsConstructor

public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(value = "employees", headers = "X-Api-Version = v1")
    public void save() {
        employeeService.create();
    }

    @GetMapping(value = "/employees", headers = "X-Api-Version=v1")
    public List<Employee> getEmployees(@RequestParam("page") Integer page,
                                       @RequestParam("size") Integer size) {
        return employeeService.findAllBy(PageRequest.of(page, size));
    }


}
