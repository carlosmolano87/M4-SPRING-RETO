package com.bancolombia.aplicacioncuenta.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import org.springframework.web.bind.annotation.*;

import com.bancolombia.aplicacioncuenta.model.DTO.CuentaDTO;
import com.bancolombia.aplicacioncuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    /*@GetMapping("/saldo")
    public ResponseEntity<Map<String, Object>> obtenerSaldo(@RequestParam String numeroCuenta) {
        BigDecimal saldo = cuentaService.obtenerSaldo(numeroCuenta);
        Map<String, Object> response = new HashMap<>();
        response.put("saldo", saldo);
        return ResponseEntity.ok(response);
    }*/

    @GetMapping("/saldo")
    public ResponseEntity<CuentaDTO> obtenerSaldo(@RequestParam String numeroCuenta) {
        Cuenta cuenta = cuentaService.obtenerSaldo(numeroCuenta);
        CuentaDTO cuentaDTO = new CuentaDTO(cuenta.getNumeroCuenta(), cuenta.getSaldo());
        return ResponseEntity.ok(cuentaDTO);
    }

    @GetMapping("/historial")
    public ResponseEntity<List<String>> obtenerHistorial(@Valid @RequestBody CuentaDTO cuenta) {
        List<String> historial = cuentaService.obtenerHistorialTransacciones(cuenta);
        return ResponseEntity.ok(historial);
    }
}
