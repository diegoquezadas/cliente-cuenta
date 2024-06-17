package com.example.cuenta_movimientos_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cuenta_movimientos_service.entity.ClienteProxy;

@FeignClient(name = "cliente-persona-service", url = "http://cliente-persona-service:8081")
public interface ClienteFeignClient {
    @GetMapping("/clientes/{id}")
    ClienteProxy getClienteById(@PathVariable("id") Long id);
}