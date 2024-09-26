package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAllEmployeesSortedByName(Pageable pageable) {

        Page<EmployeeDTO> employees = service.findAllEmployeesSortedByName(pageable);

        return ResponseEntity.ok(employees);

    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insertNewEmployee (@RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO dto = service.insertNewEmployee(employeeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}
