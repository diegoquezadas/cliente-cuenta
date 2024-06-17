package com.example.cliente_persona_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente_persona_service.entity.Persona;
import com.example.cliente_persona_service.exception.ResourceNotFoundException;
import com.example.cliente_persona_service.service.PersonaService;


@RestController
@RequestMapping("/personas")
public class PersonaController {

     @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable Long id) {
        Persona persona = personaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not found with id: " + id));
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        Persona savedPersona = personaService.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona existingPersona = personaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not found with id: " + id));

        existingPersona.setNombre(personaDetails.getNombre());
        existingPersona.setGenero(personaDetails.getGenero());
        existingPersona.setEdad(personaDetails.getEdad());
        existingPersona.setIdentificacion(personaDetails.getIdentificacion());
        existingPersona.setDireccion(personaDetails.getDireccion());
        existingPersona.setTelefono(personaDetails.getTelefono());

        Persona updatedPersona = personaService.save(existingPersona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Persona existingPersona = personaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not found with id: " + id));
        personaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
