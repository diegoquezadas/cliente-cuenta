package com.example.cuenta_movimientos_service.service;

import java.util.List;
import java.util.Optional;


import com.example.cuenta_movimientos_service.entity.Cuenta;

public interface CuentaService {


    public List<Cuenta> findAll();

    public Optional<Cuenta> findById(Long id);

    public Cuenta save(Cuenta cuenta);

    public void deleteById(Long id);

}
