/*package com.example.demo.controller;*/

import com.example.demo.model.DBFile;
import com.example.demo.model.bahta;
import com.example.demo.payload.bahtar;
import com.example.demo.service.bahtas;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hamdi
 */
/*@RestController
@RequestMapping("/api")

public class bahtac {
    @Autowired
    bahtas bahtas;
    private static final String ENTITY_NAME = "bahta";
    @PostMapping(value = "/upload", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })

	public bahta upload(@RequestPart("bahta") String bahta, @RequestPart("cv") MultipartFile cv, @RequestPart("ph") MultipartFile ph) throws IOException {

		bahta userJson = bahtas.getJson(bahta, cv, ph);
		return userJson;
	}
*/
/*****************new********/
/*@GetMapping("/upload/{fileId}")
public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
    // Load file from database

    bahta dbFile = bahtas.getFile(fileId);

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(dbFile.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
            .body(new ByteArrayResource(dbFile.getCv()));
}
}
*/