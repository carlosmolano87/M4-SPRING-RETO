package com.bancolombia.aplicacioncuenta.model.DTO;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;

public class CuentaDTO {

    @NotNull(message = "El número de cuenta no puede ser nulo")
    private String numeroCuenta;

    @NotNull(message = "El saldo no puede ser nulo")
    private BigDecimal saldo;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
