package com.example.demo.service;

import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.model.bahta;
import com.example.demo.repository.bahtare;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.repository.studentRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class studentservice {
    @Autowired
    private studentRepository studentrepository;

 /*  public Student getJson(String user, String datebirth, MultipartFile ph) throws IOException {

        String fileName = StringUtils.cleanPath(ph.getOriginalFilename());

        Student userJson = new Student();


        ObjectMapper objectMapper = new ObjectMapper();
        userJson = objectMapper.readValue(user, Student.class);
        LocalDate localDate = LocalDate.parse(datebirth);
        userJson.setDatebirth(localDate);



        userJson.setPhoto(ph.getBytes());

        userJson.setPhotoName(fileName);
        userJson.setPhotoType(ph.getContentType());
        studentrepository.save(userJson);
        return userJson;

    }

    public Student getFile(String fileId) {
        return studentrepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
    public List<Student> findAll() {
        return studentrepository.findAll();


    }*/
 /* ---------------------------------get all------------------*/
 public List<Student> findAll() {
     return studentrepository.findAll();


 }
    /*--------------------------save one ------------------*/
    public Student save(Student student) {
        return studentrepository.save(student);
    }

    /* ------------------------update student----------------- */
    public Student update(Student student) throws ResourceNotFoundException {

        Student inBase = studentrepository.findById(student.getCin())
                .orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + student.getCin()));
        inBase.setFirstname(student.getFirstname());
        inBase.setLastname(student.getLastname());
        inBase.setCity(student.getCity());
        inBase.setNationality(student.getNationality());
        inBase.setDatebirth(student.getDatebirth());
        inBase.setTel(student.getTel());



        inBase = studentrepository.save(inBase);
        return inBase;
    }
    /* ---------------find one---------*/
    public Student findOne(String id) throws ResourceNotFoundException {

        Student inBase = studentrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("STUDENT not found for this id :: " + id));

        return inBase;
    }
    /* -------------------delete by id -------------------*/
    public void delete(String id) {

        studentrepository.deleteById(id);
    }

}
