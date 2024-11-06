package com.bancolombia.aplicacioncuenta.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.aplicacioncuenta.model.DTO.CuentaDTO;
import com.bancolombia.aplicacioncuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public ResponseEntity<String> obtenerSaldo(@Valid @RequestBody CuentaDTO cuenta) {
        BigDecimal saldo = cuentaService.obtenerSaldo(cuenta);
        return ResponseEntity.ok("El saldo de la cuenta es: " + saldo);
    }

    @GetMapping("/historial")
    public ResponseEntity<List<String>> obtenerHistorial(@Valid @RequestBody CuentaDTO cuenta) {
        List<String> historial = cuentaService.obtenerHistorialTransacciones(cuenta);
        return ResponseEntity.ok(historial);
    }
}
