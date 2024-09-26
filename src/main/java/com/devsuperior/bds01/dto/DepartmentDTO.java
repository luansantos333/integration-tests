package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

public class DepartmentDTO {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public DepartmentDTO (Department entity) {

        id = entity.getId();
        name = entity.getName();

    }

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
