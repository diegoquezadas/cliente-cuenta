package com.example.cuenta_movimientos_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.cuenta_movimientos_service.model.ClienteDTO;

@Service
public class ClienteEventListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recibirEventoCliente(ClienteDTO clienteDTO) {
        System.out.println("Recibido evento del cliente: " + clienteDTO);
    }
}
