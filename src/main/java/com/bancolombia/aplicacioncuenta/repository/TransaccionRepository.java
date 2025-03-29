package com.bancolombia.aplicacioncuenta.repository;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import com.bancolombia.aplicacioncuenta.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCuentaOrderByFechaDesc(Cuenta cuenta);
}