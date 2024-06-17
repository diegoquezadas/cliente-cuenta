package com.example.cuenta_movimientos_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuenta_movimientos_service.entity.Movimiento;
import com.example.cuenta_movimientos_service.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    
    
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoService.findById(id);
        return movimiento.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento) {
        Movimiento createdMovimiento = movimientoService.save(movimiento);
        return ResponseEntity.status(201).body(createdMovimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoDetails) {
        Optional<Movimiento> optionalMovimiento = movimientoService.findById(id);
        
        if (optionalMovimiento.isPresent()) {
            Movimiento existingMovimiento = optionalMovimiento.get();
            existingMovimiento.setFecha(movimientoDetails.getFecha());
            existingMovimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
            existingMovimiento.setValor(movimientoDetails.getValor());
            existingMovimiento.setSaldo(movimientoDetails.getSaldo());
            existingMovimiento.setCuenta(movimientoDetails.getCuenta());
            
            Movimiento updatedMovimiento = movimientoService.save(existingMovimiento);
            return ResponseEntity.ok(updatedMovimiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        Optional<Movimiento> optionalMovimiento = movimientoService.findById(id);
        
        if (optionalMovimiento.isPresent()) {
            movimientoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}