package com.bancolombia.aplicacioncuenta.service;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import com.bancolombia.aplicacioncuenta.model.DTO.CuentaDTO;
import com.bancolombia.aplicacioncuenta.model.Transaccion;
import com.bancolombia.aplicacioncuenta.repository.CuentaRepository;
import com.bancolombia.aplicacioncuenta.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public CuentaService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public Cuenta obtenerSaldo(String numeroCuenta) {
        return obtenerCuentaPorNumero(numeroCuenta);

    }

    public List<String> obtenerHistorialTransacciones(CuentaDTO cuentaDTO) {
        Cuenta cuenta = obtenerCuentaPorNumero(cuentaDTO.getNumeroCuenta());
        List<Transaccion> transacciones = transaccionRepository.findByCuentaOrderByFechaDesc(cuenta);

        return transacciones.stream()
                .limit(5)
                .map(transaccion -> String.format("ID: %s, Tipo: %s, Monto: %s, Fecha: %s",
                        transaccion.getId(),
                        transaccion.getTipo(),
                        transaccion.getMonto(),
                        transaccion.getFecha()))
                .collect(Collectors.toList());
    }

    private Cuenta obtenerCuentaPorNumero(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada."));
    }
}