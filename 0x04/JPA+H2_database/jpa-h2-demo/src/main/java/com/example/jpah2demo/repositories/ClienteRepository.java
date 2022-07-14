package com.example.jpah2demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpah2demo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
