package com.example.cuenta_movimientos_service.service.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cuenta_movimientos_service.entity.Movimiento;
import com.example.cuenta_movimientos_service.repository.MovimientoRepository;
import com.example.cuenta_movimientos_service.service.ReporteService;

public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    

    @Override
    public List<Movimiento> getReport(Long clienteId, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

        return movimientoRepository.findMovimientosByClienteAndDateRange(clienteId, startDateTime, endDateTime);
    }
}
