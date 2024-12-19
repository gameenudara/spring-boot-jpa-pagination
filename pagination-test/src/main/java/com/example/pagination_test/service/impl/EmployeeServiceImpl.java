package com.example.pagination_test.service.impl;

import com.example.pagination_test.model.Employee;
import com.example.pagination_test.repository.EmployeeRepository;
import com.example.pagination_test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void create() {

        for (int i = 0; i < 1000; i++) {
            Employee employee = new Employee();
            employee.setName("name" + i);
            employee.setSalary(genarateRandomSalary(5000, 10000));
            employeeRepository.save(employee);
        }

    }

    public Long genarateRandomSalary(int minSalary, int maxSalary) {
        int range = maxSalary - minSalary;
        return (long) (minSalary + (Math.random() * range));
    }
}
