package com.example.dao;

import com.example.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HelloDAO extends JpaRepository<Hello, Integer> {

    @Query(value = "SELECT t.id, t.name FROM test t WHERE t.name = :name", nativeQuery = true)
    Hello select(@Param("name") String name);
}
