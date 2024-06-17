package com.example.cuenta_movimientos_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuenta_movimientos_service.entity.Cuenta;
import com.example.cuenta_movimientos_service.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaService.findById(id);
        return cuenta.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
        Cuenta createdCuenta = cuentaService.save(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaDetails) {
        Optional<Cuenta> optionalCuenta = cuentaService.findById(id);
        
        if (optionalCuenta.isPresent()) {
            Cuenta existingCuenta = optionalCuenta.get();
            existingCuenta.setNumeroCuenta(cuentaDetails.getNumeroCuenta());
            existingCuenta.setTipoCuenta(cuentaDetails.getTipoCuenta());
            existingCuenta.setSaldo(cuentaDetails.getSaldo());
            existingCuenta.setEstado(cuentaDetails.getEstado());
            existingCuenta.setCliente(cuentaDetails.getCliente());
            
            Cuenta updatedCuenta = cuentaService.save(existingCuenta);
            return ResponseEntity.ok(updatedCuenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        Optional<Cuenta> optionalCuenta = cuentaService.findById(id);
        
        if (optionalCuenta.isPresent()) {
            cuentaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
