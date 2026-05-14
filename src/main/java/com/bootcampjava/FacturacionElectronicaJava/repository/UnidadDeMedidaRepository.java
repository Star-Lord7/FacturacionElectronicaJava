package com.bootcampjava.FacturacionElectronicaJava.repository;

import com.bootcampjava.FacturacionElectronicaJava.models.UnidadDeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadDeMedidaRepository extends JpaRepository<UnidadDeMedida,Long> {
}
