package com.example.cuenta_movimientos_service.service;

import java.util.List;

import com.example.cuenta_movimientos_service.entity.Movimiento;

public interface ReporteService {

     List<Movimiento> getReport(Long clienteId, String startDate, String endDate);

}
