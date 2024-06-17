package com.example.cuenta_movimientos_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteProxy extends PersonaProxy {
    private String contrasena;
    private Boolean estado;
}
