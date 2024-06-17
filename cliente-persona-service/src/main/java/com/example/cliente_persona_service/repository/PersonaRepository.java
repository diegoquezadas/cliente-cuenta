package com.example.cliente_persona_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cliente_persona_service.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}