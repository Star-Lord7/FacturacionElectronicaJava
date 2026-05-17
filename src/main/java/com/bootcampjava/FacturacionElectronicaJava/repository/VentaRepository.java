package com.bootcampjava.FacturacionElectronicaJava.repository;

import com.bootcampjava.FacturacionElectronicaJava.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
