package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.model.bahta;
import com.example.demo.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:58893")
@RestController
@RequestMapping("/api")
public class studentController {
    @Autowired
    studentservice studentservice;
    private static final String ENTITY_NAME = "Student";

    /*
    @PostMapping(value = "/student", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })

    public Student post(@RequestPart("student") String student,@RequestPart("datebirth") String datebirth,  @RequestPart("photo") MultipartFile photo) throws IOException {

        Student userJson = studentservice.getJson(student, datebirth,  photo);

        return userJson;
    }


    @GetMapping("/studentphoto/{Id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String Id) {
        // Load file from database

        Student dbFile = studentservice.getFile(Id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getPhotoType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getPhotoName() + "\"")
                .body(new ByteArrayResource(dbFile.getPhoto()));
    }
    @GetMapping("/student")
    public List<Student> findAll() {
        return studentservice.findAll();
    }

     */
    @GetMapping("/student")
    public List<Student> findAll() {
        return  studentservice.findAll();
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student Student){

        Student result =  studentservice.save(Student);
        return result;
    }

    @DeleteMapping("/student/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") String StudentId)
            throws ResourceNotFoundException {
        studentservice.delete(StudentId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentbyid(@PathVariable String id) throws ResourceNotFoundException {

        Student dto =  studentservice.findOne(id);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable String id,  @RequestBody Student Student) throws MethodArgumentNotValidException, ResourceNotFoundException {

        Student.setCin(id);
        Student result = studentservice.update(Student);
        return ResponseEntity.ok().body(result);
    }

}
