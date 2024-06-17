package com.example.cliente_persona_service.service;

import java.util.List;
import java.util.Optional;

import com.example.cliente_persona_service.entity.Cliente;

public interface ClienteService {

    List<Cliente> findAll();
    Cliente  save(Cliente cliente);
    Optional<Cliente> findById(Long id);
    Cliente update(Cliente cliente);
    void deleteById(Long id);
}
