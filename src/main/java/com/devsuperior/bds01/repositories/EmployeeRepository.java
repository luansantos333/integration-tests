package com.devsuperior.bds01.repositories;

import com.devsuperior.bds01.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {


    @Query("SELECT o FROM Employee o ORDER BY o.name")
    Page<Employee> searchAllEmployeesOrderedByName(Pageable pageable);


}
