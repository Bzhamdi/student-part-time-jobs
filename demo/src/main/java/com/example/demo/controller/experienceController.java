package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Experience;
import com.example.demo.model.skills;
import com.example.demo.service.experienceservice;
import com.example.demo.service.skillsservice;
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
public class experienceController {
    @Autowired
    experienceservice experienceserviceservice;
    private static final String ENTITY_NAME = "Experience";


    @GetMapping("/experience")
    public List<Experience> findAll() {
        return experienceserviceservice.findAll();
    }

    @PostMapping("/experience")
    public Experience postExperience(@RequestBody Experience experience){

        Experience result = experienceserviceservice.save(experience);
        return result;
    }

    @DeleteMapping("/experience/{id}")
    public Map<String, Boolean> deleteExperience(@PathVariable(value = "id") Long experienceId)
            throws ResourceNotFoundException {
        experienceserviceservice.delete(experienceId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/experience/{id}")
    public ResponseEntity<Experience> getExperiencebyid(@PathVariable Integer id) throws ResourceNotFoundException {

        Experience dto = experienceserviceservice.findOne(id);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/experience/{id}")
    public ResponseEntity<Experience> updateExperienceById(@PathVariable Integer id,  @RequestBody Experience experience) throws MethodArgumentNotValidException, ResourceNotFoundException {

        experience.setId(id);
        Experience result =experienceserviceservice.update(experience);
        return ResponseEntity.ok().body(result);
    }
}
