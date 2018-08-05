package com.example.controller;

import com.example.document.Document;
import com.example.document.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/docs")
@CrossOrigin(origins = "*")
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @RequestMapping("/save")
    ResponseEntity<String> save(String userId, String contents) {
        Document document = new Document();
        document.setUserId(userId);
        document.setContents(contents);
        Document save = documentRepository.save(document);
        String response = save.toString();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping("/read")
    ResponseEntity<List<Document>> read(String userId) {
//        Optional<Document> document = documentRepository.findById(1);
        List<Document> all = documentRepository.findAll();

        return new ResponseEntity<List<Document>>(all, HttpStatus.OK);
    }
}
