package com.example.demo.repository;

import com.example.demo.model.skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface skillsRepository  extends JpaRepository<skills, Long> {
}
