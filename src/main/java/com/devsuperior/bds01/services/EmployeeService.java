package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import com.devsuperior.bds01.services.exceptions.EmptyTableException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional (readOnly = true)
    public Page<EmployeeDTO> findAllEmployeesSortedByName (Pageable p) {

        Page<Employee> employees = repository.searchAllEmployeesOrderedByName(p);

        if (employees.isEmpty()) {

            throw new EmptyTableException("Table employees is empty");

        }

        return employees.map(employee -> new EmployeeDTO(employee));
    }


    @Transactional
    public EmployeeDTO insertNewEmployee (EmployeeDTO employee) {

        Employee e = new Employee();
        e.setName(employee.getName());
        e.setEmail(employee.getEmail());
        e.setDepartment(new Department());
        e.setDepartment(new Department());
        e.getDepartment().id = employee.getDepartmentId();
        Employee savedEntity = repository.save(e);

        return new EmployeeDTO(savedEntity);

    }


}
