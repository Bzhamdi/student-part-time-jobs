/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.exception.FileNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hamdi
 */
@Service
@Transactional
public class Userservice {
     @Autowired
    private UserRepository userRepository;
     
     public List<User> findAll() {
        return userRepository.findAll();
        
    
}
 public User save(User user) {
return userRepository.save(user);
}

}
