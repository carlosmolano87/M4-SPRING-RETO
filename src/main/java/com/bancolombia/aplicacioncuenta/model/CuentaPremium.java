package com.bancolombia.aplicacioncuenta.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Premium")
public class CuentaPremium extends Cuenta {

    @Override
    public void depositoSucursal(BigDecimal cantidad) {
        BigDecimal saldo = getSaldo();
        saldo = saldo.add(cantidad);
        setSaldo(saldo);
    }

    @Override
    public void depositoCajeroAutomatico(BigDecimal cantidad) {
        BigDecimal saldo = getSaldo();
        saldo = saldo.add(cantidad);
        setSaldo(saldo);
    }

    @Override
    public void depositoOtraCuenta(BigDecimal cantidad) {
        BigDecimal saldo = getSaldo();
        saldo = saldo.add(cantidad.subtract(new BigDecimal("1.5")));
        setSaldo(saldo);
    }

    @Override
    public void compraEstablecimientoFisico(BigDecimal cantidad) {
        BigDecimal saldo = getSaldo();
        saldo = saldo.subtract(cantidad);
        setSaldo(saldo);
    }

    @Override
    public void compraPaginaWeb(BigDecimal cantidad) {
        BigDecimal saldo = getSaldo();
        saldo = saldo.subtract(cantidad.add(new BigDecimal("5")));
        setSaldo(saldo);
    }

    @Override
    public void retiroCajero(BigDecimal cantidad) {
        BigDecimal saldo = getSaldo();
        saldo = saldo.subtract(cantidad);
        setSaldo(saldo);
    }

}
