package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.services.exceptions.EmptyTableException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<DepartmentDTO> findAll () {

        List<Department> departmentList = repository.findAll();

        Collections.sort(departmentList, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
               return  o1.getName().compareTo(o2.getName());
            }
        });

        if (departmentList.isEmpty()) {

            throw new EmptyTableException("Table is empty");

        }

        return departmentList.stream().map(department -> new DepartmentDTO(department)).collect(Collectors.toList());


    }


}
