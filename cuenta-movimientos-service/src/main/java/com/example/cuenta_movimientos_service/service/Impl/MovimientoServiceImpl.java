package com.example.cuenta_movimientos_service.service.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuenta_movimientos_service.entity.Cuenta;
import com.example.cuenta_movimientos_service.entity.Movimiento;
import com.example.cuenta_movimientos_service.exception.ResourceNotFoundException;
import com.example.cuenta_movimientos_service.exception.SaldoNoDisponibleException;
import com.example.cuenta_movimientos_service.repository.CuentaRepository;
import com.example.cuenta_movimientos_service.repository.MovimientoRepository;
import com.example.cuenta_movimientos_service.service.MovimientoService;

import jakarta.transaction.Transactional;

@Service
public class MovimientoServiceImpl implements MovimientoService{


    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    @Transactional
    public Movimiento save(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));

        BigDecimal saldoActual = cuenta.getSaldo();
        BigDecimal nuevoSaldo = saldoActual.add(movimiento.getTipoMovimiento().equals("Deposito") ? movimiento.getValor() : movimiento.getValor().negate());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoNoDisponibleException("Saldo no disponible");
        }

        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movimiento.setSaldo(nuevoSaldo);
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }
}
