package com.example.cuenta_movimientos_service.service;

import java.util.List;
import java.util.Optional;

import com.example.cuenta_movimientos_service.entity.Movimiento;

public interface MovimientoService {

    List<Movimiento> findAll();

    Movimiento save(Movimiento movimiento);

    Optional<Movimiento> findById(Long id);

    void deleteById(Long id);

}
