package com.example.cuenta_movimientos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuenta_movimientos_service.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}