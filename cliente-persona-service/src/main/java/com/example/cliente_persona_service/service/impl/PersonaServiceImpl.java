package com.example.cliente_persona_service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cliente_persona_service.entity.Persona;
import com.example.cliente_persona_service.repository.PersonaRepository;
import com.example.cliente_persona_service.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona update(Persona persona) {
        if(personaRepository.existsById(persona.getId())) {
            return personaRepository.save(persona);
        } else {
            throw new RuntimeException("Cliente not found with id " + persona.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if(personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente not found with id " + id);
        }
    }

    
}
