package com.example.pagination_test.service.impl;

import com.example.pagination_test.model.Employee;
import com.example.pagination_test.repository.EmployeeRepository;
import com.example.pagination_test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Employee> findAllBy(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAllBy(pageable);
        System.out.println("total pages  : " + employeePage.getTotalPages());
        System.out.println("total elements : " + employeePage.getTotalPages());
        System.out.println("current page " + employeePage.getNumber());
        System.out.println("page size " + employeePage.getNumberOfElements());
        return employeePage.getContent();
    }

    @Override
    public List<Employee> findAllBySort(Sort sort) {
        return employeeRepository.findAllBy(sort);
    }


    public Long genarateRandomSalary(int minSalary, int maxSalary) {
        int range = maxSalary - minSalary;
        return (long) (minSalary + (Math.random() * range));
    }


}
