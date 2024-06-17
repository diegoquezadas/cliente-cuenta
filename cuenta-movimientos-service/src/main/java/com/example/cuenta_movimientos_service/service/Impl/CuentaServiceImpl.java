package com.example.cuenta_movimientos_service.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuenta_movimientos_service.entity.ClienteProxy;
import com.example.cuenta_movimientos_service.entity.Cuenta;
import com.example.cuenta_movimientos_service.repository.CuentaRepository;
import com.example.cuenta_movimientos_service.service.ClienteFeignClient;
import com.example.cuenta_movimientos_service.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteFeignClient clienteFeignClient;

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        ClienteProxy cliente = clienteFeignClient.getClienteById(cuenta.getCliente().getId());
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        cuenta.setCliente(cliente);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
}
