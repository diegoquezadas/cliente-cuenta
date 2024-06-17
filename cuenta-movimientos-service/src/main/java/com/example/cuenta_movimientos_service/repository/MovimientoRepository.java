package com.example.cuenta_movimientos_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cuenta_movimientos_service.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaId(Long cuentaId);

    @Query("SELECT m FROM Movimiento m JOIN m.cuenta c WHERE c.cliente.id = :clienteId AND m.fecha BETWEEN :startDate AND :endDate")
    List<Movimiento> findMovimientosByClienteAndDateRange(@Param("clienteId") Long clienteId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
}