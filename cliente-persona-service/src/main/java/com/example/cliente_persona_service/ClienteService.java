package com.example.cliente_persona_service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cliente_persona_service.entity.Cliente;

@Service
public class ClienteService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publicarEventoCliente(Cliente cliente) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, cliente);
    }

    // Métodos para crear/modificar clientes
    public Cliente crearCliente(Cliente cliente) {
        // lógica para crear cliente
        publicarEventoCliente(cliente);
        return cliente;
    }
}
