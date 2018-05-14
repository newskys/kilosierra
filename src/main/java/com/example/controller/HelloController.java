package com.example.controller;

import com.example.dao.HelloDAO;
import com.example.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private HelloDAO helloDAO;

    @RequestMapping("/add")
    public Hello add(Hello hello) {

        Hello helloData = helloDAO.save(hello);

        return helloData;
    }

    @RequestMapping("/list")
    public List<Hello> list() {

        List<Hello> helloList = helloDAO.findAll();

        return helloList;
    }

    @RequestMapping("/select")
    public Hello list(String name) {

        Hello hello = helloDAO.select(name);

        return hello;
    }

    @RequestMapping("/")
    public String index() {
        return "helloworld!";
    }
}
