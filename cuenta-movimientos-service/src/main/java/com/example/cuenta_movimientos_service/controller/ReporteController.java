package com.example.cuenta_movimientos_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuenta_movimientos_service.entity.Movimiento;
import com.example.cuenta_movimientos_service.service.ReporteService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Movimiento>> getReport(@RequestParam Long clienteId,
                                                      @RequestParam String startDate,
                                                      @RequestParam String endDate) {
        List<Movimiento> movimientos = reporteService.getReport(clienteId, startDate, endDate);
        return ResponseEntity.ok(movimientos);
    }
}
