/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.bahta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 *
 * @author hamdi
 */
public interface bahtare extends JpaRepository<bahta, String> {
    Optional<bahta> findByNom(String name);
    
}
