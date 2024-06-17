package com.example.cliente_persona_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.cliente_persona_service.entity.Cliente;
import com.example.cliente_persona_service.repository.ClienteRepository;
import com.example.cliente_persona_service.service.ClienteService;

@SpringBootTest
class ClientePersonaServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Jose Quintero");

        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = clienteService.save(cliente);

        assertNotNull(savedCliente);
        assertEquals("Jose Quintero", savedCliente.getNombre());
    }

    @Test
    public void testGetClienteById() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Jose Quintero");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> foundCliente = clienteService.findById(1L);

        assertTrue(foundCliente.isPresent());
        assertEquals("Jose Quintero", foundCliente.get().getNombre());
    }

}
