package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAllDepartments() {
        List<DepartmentDTO> all = service.findAll();
        return ResponseEntity.ok(all);

    }


}
