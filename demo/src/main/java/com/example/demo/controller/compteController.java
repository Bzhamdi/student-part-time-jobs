package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Compte;
import com.example.demo.model.Experience;
import com.example.demo.service.compteService;
import com.example.demo.service.experienceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:58893")
@RestController
@RequestMapping("/api")
public class compteController {

    @Autowired
    compteService service;
    private static final String ENTITY_NAME = "Compte";

    @PostMapping("/compte")
    public ResponseEntity<Compte> postCompte(@RequestBody Compte Compte){

        Compte result = service.save(Compte);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/compte/{id}")
    public ResponseEntity<Compte> getComptebyid(@PathVariable String id) throws ResourceNotFoundException {

        Compte dto = service.findOne(id);

        return ResponseEntity.ok().body(dto);
    }


    @GetMapping("/compte/{id}/{password}")
    public ResponseEntity<Compte> getComptebyidandpassword(@PathVariable String id, @PathVariable String password) throws ResourceNotFoundException {

        Compte dto = service.findbEmailAndPassword(id, password);

        return ResponseEntity.ok().body(dto);
    }
}
