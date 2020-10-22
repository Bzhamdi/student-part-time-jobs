package com.example.demo.repository;


import com.example.demo.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface formationRepository extends JpaRepository<Formation, Long> {
}
