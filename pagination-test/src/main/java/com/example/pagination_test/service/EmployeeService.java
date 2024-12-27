package com.example.pagination_test.service;

import com.example.pagination_test.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    void create();

    List<Employee> findAllBy(Pageable pageable);

    List<Employee> findAllBySort(Sort sort);

    List<Employee> findAllByMinSalary(Long minSalary, Pageable pageable);
}
