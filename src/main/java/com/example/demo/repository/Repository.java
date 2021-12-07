package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Pessoa;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Pessoa, Long>{

}
