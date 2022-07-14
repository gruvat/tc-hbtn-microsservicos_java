package com.example.jpah2demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpah2demo.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}
