package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.service.companyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:58893")
@RestController
@RequestMapping("/api")
public class companyController {

    @Autowired
    companyservice Companyservice;
    private static final String ENTITY_NAME = "Company";

    @GetMapping("/Company")
    public List<Company> findAll() {
        return Companyservice.findAll();
    }

    @PostMapping("/Company")
    public Company postCompany(@RequestBody Company Company){

        Company result = Companyservice.save(Company);
        return result;
    }

    @DeleteMapping("/Company/{id}")
    public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") String CompanyId)
            throws ResourceNotFoundException {
        Companyservice.delete(CompanyId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/Company/{id}")
    public ResponseEntity<Company> getCompanybyid(@PathVariable String id) throws ResourceNotFoundException {

        Company dto = Companyservice.findOne(id);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/Company/{id}")
    public ResponseEntity<Company> updateCompanyById(@PathVariable String id,  @RequestBody Company Company) throws MethodArgumentNotValidException, ResourceNotFoundException {

        Company.setId(id);
        Company result =Companyservice.update(Company);
        return ResponseEntity.ok().body(result);
    }

}
