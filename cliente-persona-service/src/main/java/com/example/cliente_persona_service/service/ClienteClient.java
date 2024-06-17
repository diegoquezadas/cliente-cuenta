package com.example.cliente_persona_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cliente_persona_service.entity.Cliente;

@FeignClient(name = "cliente-service", url = "http://cliente-service")
public interface ClienteClient {
    
    @PostMapping("/clientes")
    Cliente saveCliente(@RequestBody Cliente cliente);
}
