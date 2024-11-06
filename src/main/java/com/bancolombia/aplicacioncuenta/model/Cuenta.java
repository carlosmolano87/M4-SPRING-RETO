package com.bancolombia.aplicacioncuenta.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoCuenta")
@Table(name = "cuenta")
public abstract class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected BigDecimal saldo;

    protected String numerocuenta;

    private String tipo;

    @Column(nullable = false)
    private String titular;

    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transacciones;

    public Cuenta(Long id, BigDecimal saldo, String titular) {
        this.id = id;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Cuenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Transaccion> getTransacciones() {
            if (transacciones == null || transacciones.isEmpty()) {
        return Collections.emptyList();
    }
    
    return transacciones.stream()
            .sorted(Comparator.comparing(Transaccion::getFecha).reversed())
            .limit(5)
            .collect(Collectors.toList());
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public static class CuentaPremium {
    }

    public static class CuentaBasica {
    }

    public abstract void depositoSucursal(BigDecimal cantidad);

    public abstract void depositoCajeroAutomatico(BigDecimal cantidad);

    public abstract void depositoOtraCuenta(BigDecimal cantidad);

    public abstract void compraEstablecimientoFisico(BigDecimal cantidad);

    public abstract void compraPaginaWeb(BigDecimal cantidad);

    public abstract void retiroCajero(BigDecimal cantidad);
}