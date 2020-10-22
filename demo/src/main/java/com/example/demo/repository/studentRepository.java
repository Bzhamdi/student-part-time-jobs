package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.bahta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, String>{

}
