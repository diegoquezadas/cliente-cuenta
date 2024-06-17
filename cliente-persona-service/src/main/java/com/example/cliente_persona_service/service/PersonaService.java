package com.example.cliente_persona_service.service;

import java.util.List;
import java.util.Optional;

import com.example.cliente_persona_service.entity.Persona;

public interface PersonaService {

     List<Persona> findAll();

     Persona save(Persona persona);

     Optional<Persona> findById(Long id);

     Persona update(Persona persona);

     void deleteById(Long id);
}
