package com.example.jpah2demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpah2demo.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
