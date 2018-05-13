package com.example.dao;

import com.example.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloDAO extends JpaRepository<Hello, Integer> {
}
