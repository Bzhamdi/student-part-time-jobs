package com.example.demo.service;

import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Photo;
import com.example.demo.model.Student;
import com.example.demo.model.icon;
import com.example.demo.repository.iconRepository;
import com.example.demo.repository.photoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class Photoservice {

    @Autowired
    private photoRepository photorepository;
    @Autowired
    private studentservice studentservice;


    public Photo getJson(String student_id, MultipartFile ph) throws IOException, ResourceNotFoundException {
/****new*/
        System.out.println("---------------------------------1111111----------------");
        String fileName = StringUtils.cleanPath(ph.getOriginalFilename());
        /******/
        Photo userJson = new Photo();
        ObjectMapper objectMapper = new ObjectMapper();
        userJson.setStudentid(student_id);
        userJson.setPhoto(ph.getBytes());
        /**new**/
        userJson.setPhotoName(fileName);
        userJson.setPhotoType(ph.getContentType());

        photorepository.save(userJson);

        Student stu = studentservice.findOne(student_id);
        System.out.println("-----------------------ttttt-----------");
        stu.setStudentPhoto(userJson);

        return userJson;

    }
    public Photo update(long id, MultipartFile ph) throws ResourceNotFoundException, IOException {
        String fileName = StringUtils.cleanPath(ph.getOriginalFilename());

        Photo inBase = photorepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PHOTO not found for this id :: " + id));

        inBase.setPhoto(ph.getBytes());
        /**new**/
        inBase.setPhotoName(fileName);
        inBase.setPhotoType(ph.getContentType());

        inBase = photorepository.save(inBase);
        return inBase;
    }

    public Photo getFile(String student_id) {
        return  photorepository.findByStudentid(student_id)
                .orElseThrow(() -> new FileNotFoundException("Photo not found with company id " + student_id));
    }
    public List<Photo> findAll() {
        return photorepository.findAll();


    }

}
