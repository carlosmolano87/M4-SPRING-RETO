package com.bancolombia.aplicacioncuenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bancolombia.aplicacioncuenta.model.DTO.TransaccionDTO;
import com.bancolombia.aplicacioncuenta.service.TransaccionService;

import jakarta.validation.Valid;

public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/deposito/sucursal")
    public ResponseEntity<String> depositoSucursal(@Valid @RequestBody TransaccionDTO transaccion) {
        transaccionService.depositoSucursal(transaccion);
        return ResponseEntity.ok("Depósito en sucursal realizado con éxito.");
    }

    @PostMapping("/deposito/cajero")
    public ResponseEntity<String> depositoCajero(@Valid @RequestBody TransaccionDTO transaccion) {
        transaccionService.depositoCajeroAutomatico(transaccion);
        return ResponseEntity.ok("Depósito en cajero automático realizado con éxito.");
    }

    @PostMapping("/deposito/otra-cuenta")
    public ResponseEntity<String> depositoOtraCuenta(@Valid @RequestBody TransaccionDTO transaccion) {
        transaccionService.depositoDesdeOtraCuenta(transaccion);
        return ResponseEntity.ok("Depósito desde otra cuenta realizado con éxito.");
    }

    @PostMapping("/compra/establecimiento")
    public ResponseEntity<String> compraEstablecimientoFisico(@Valid @RequestBody TransaccionDTO transaccion) {
        transaccionService.compraEstablecimientoFisico(transaccion);
        return ResponseEntity.ok("Compra en establecimiento físico realizada con éxito.");
    }

    @PostMapping("/compra/web")
    public ResponseEntity<String> compraPaginaWeb(@Valid @RequestBody TransaccionDTO transaccion) {
        transaccionService.compraPaginaWeb(transaccion);
        return ResponseEntity.ok("Compra en página web realizada con éxito.");
    }

    @PostMapping("/retiro/cajero")
    public ResponseEntity<String> retiroCajero(@Valid @RequestBody TransaccionDTO transaccion) {
        transaccionService.retiroCajero(transaccion);
        return ResponseEntity.ok("Retiro en cajero realizado con éxito.");
    }

    @GetMapping("/historial/{numeroCuenta}")
    public ResponseEntity<List<String>> obtenerHistorial(@PathVariable String numeroCuenta) {
        List<String> historial = transaccionService.obtenerHistorialTransacciones(numeroCuenta);
        return ResponseEntity.ok(historial);
    }
}
