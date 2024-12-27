package com.example.pagination_test.repository;

import com.example.pagination_test.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAllBy(Pageable pageable);

    List<Employee> findAllBy(Sort sort);

    @Query("FROM Employee  where salary >= :min_salary ORDER BY salary DESC")
    List<Employee> findAllByMinSalary(@Param("min_salary") Long minSalary, Pageable pageable);

}
