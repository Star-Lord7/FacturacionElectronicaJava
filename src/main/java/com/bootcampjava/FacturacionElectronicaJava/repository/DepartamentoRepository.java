package com.bootcampjava.FacturacionElectronicaJava.repository;

import com.bootcampjava.FacturacionElectronicaJava.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
}
