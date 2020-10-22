package com.example.demo.repository;

import com.example.demo.model.Experience;

import org.springframework.data.jpa.repository.JpaRepository;

public interface experienceRepository extends JpaRepository<Experience, Long> {
}
