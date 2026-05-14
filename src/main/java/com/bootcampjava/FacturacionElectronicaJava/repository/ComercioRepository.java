package com.bootcampjava.FacturacionElectronicaJava.repository;

import com.bootcampjava.FacturacionElectronicaJava.models.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio,Long> {
}
