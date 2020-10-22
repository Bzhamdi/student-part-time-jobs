/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.exception.FileNotFoundException;
import com.example.demo.model.DBFile;
import com.example.demo.model.bahta;
import com.example.demo.payload.bahtar;
import com.example.demo.repository.bahtare;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hamdi
 */
@Service
@Transactional
public class bahtas {
    @Autowired
    private bahtare bahtare;
    
    public bahta getJson(String user, MultipartFile cv, MultipartFile ph) throws IOException {
/****new*/
		String fileName = StringUtils.cleanPath(cv.getOriginalFilename());
		/******/
		bahta userJson = new bahta();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
			userJson = objectMapper.readValue(user, bahta.class);
		
		userJson.setCv(cv.getBytes());
                userJson.setPh(ph.getBytes());
                /**new**/
                userJson.setFileName(fileName);
                userJson.setFileType(cv.getContentType());
		bahtare.save(userJson);
		return userJson;
    
}
/**********new***/
	public bahta getFile(String fileId) {
		return bahtare.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}


}
