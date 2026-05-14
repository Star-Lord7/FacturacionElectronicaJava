package com.bootcampjava.FacturacionElectronicaJava.repository;

import com.bootcampjava.FacturacionElectronicaJava.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
