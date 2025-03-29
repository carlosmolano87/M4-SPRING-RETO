package com.bancolombia.aplicacioncuenta.service;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import com.bancolombia.aplicacioncuenta.model.CuentaBasica;
import com.bancolombia.aplicacioncuenta.model.CuentaPremium;
import com.bancolombia.aplicacioncuenta.model.Transaccion;
import com.bancolombia.aplicacioncuenta.model.Transaccion.TipoTransaccion;
import com.bancolombia.aplicacioncuenta.model.DTO.TransaccionDTO;
import com.bancolombia.aplicacioncuenta.repository.CuentaRepository;
import com.bancolombia.aplicacioncuenta.repository.TransaccionRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public TransaccionService(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Transactional
    public void depositoSucursal(TransaccionDTO transaccionDTO) {
        realizarTransaccion(transaccionDTO, BigDecimal.ZERO, TipoTransaccion.DEPOSITO_SUCURSAL);
    }

    @Transactional
    public void depositoCajeroAutomatico(TransaccionDTO transaccionDTO) {
        realizarTransaccion(transaccionDTO, BigDecimal.valueOf(2), TipoTransaccion.DEPOSITO_CAJERO);
    }

    @Transactional
    public void depositoDesdeOtraCuenta(TransaccionDTO transaccionDTO) {
        realizarTransaccion(transaccionDTO, BigDecimal.valueOf(1.5), TipoTransaccion.DEPOSITO_OTRA_CUENTA);
    }

    @Transactional
    public void compraEstablecimientoFisico(TransaccionDTO transaccionDTO) {
        realizarTransaccion(transaccionDTO, BigDecimal.ZERO, TipoTransaccion.COMPRA_ESTABLECIMIENTO);
    }

    @Transactional
    public void compraPaginaWeb(TransaccionDTO transaccionDTO) {
        realizarTransaccion(transaccionDTO, BigDecimal.valueOf(5), TipoTransaccion.COMPRA_WEB);
    }

    @Transactional
    public void retiroCajero(TransaccionDTO transaccionDTO) {
        realizarTransaccion(transaccionDTO, BigDecimal.valueOf(1), TipoTransaccion.RETIRO_CAJERO);
    }

    public List<String> obtenerHistorialTransacciones(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Cuenta no encontrada con el número de cuenta proporcionado"));

        return transaccionRepository.findByCuentaOrderByFechaDesc(cuenta)
                .stream()
                .limit(5)
                .map(transaccion -> transaccion.toString())                                                            
                .collect(Collectors.toList());
    }

    private void realizarTransaccion(TransaccionDTO transaccionDTO, BigDecimal costo, TipoTransaccion tipoTransaccion) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(transaccionDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Cuenta no encontrada con el número de cuenta proporcionado"));

        BigDecimal monto = transaccionDTO.getMonto();
        validarMontoPositivo(monto);

        if (cuenta instanceof CuentaBasica && costo.compareTo(BigDecimal.ZERO) > 0) {
            monto = monto.subtract(costo);
        }

        if (tipoTransaccion == TipoTransaccion.RETIRO_CAJERO || tipoTransaccion.name().startsWith("COMPRA")) {
            verificarSaldoSuficiente(cuenta, monto);
            cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
        } else {
            cuenta.setSaldo(cuenta.getSaldo().add(monto));
        }

        registrarTransaccion(cuenta, tipoTransaccion, monto);
        cuentaRepository.save(cuenta);
    }

    private void registrarTransaccion(Cuenta cuenta, TipoTransaccion tipo, BigDecimal monto) {
        Transaccion transaccion = new Transaccion();
        transaccion.setCuenta(cuenta);
        transaccion.setTipo(tipo);
        transaccion.setMonto(monto);
        transaccion.setFecha(new Date());

        transaccionRepository.save(transaccion);
    }

    private void validarMontoPositivo(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
    }

    private void verificarSaldoSuficiente(Cuenta cuenta, BigDecimal monto) {
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar la transacción");
        }
    }
}
