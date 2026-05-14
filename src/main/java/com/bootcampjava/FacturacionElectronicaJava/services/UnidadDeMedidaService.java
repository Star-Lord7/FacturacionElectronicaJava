package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.UnidadDeMedida;
import com.bootcampjava.FacturacionElectronicaJava.repository.UnidadDeMedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadDeMedidaService {

    private final UnidadDeMedidaRepository repo;

    public UnidadDeMedidaService(UnidadDeMedidaRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS DEPARTAMENTOS
    public List<UnidadDeMedida> todasUnidadesDeMedida(){
        return  repo.findAll();
    }

    // OBTENER UN DEPARTAMENTO
    public UnidadDeMedida unaUnidadDeMedida(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN DEPARTAMENTO
    public UnidadDeMedida guardar(UnidadDeMedida unidadDeMedida){
        return repo.save(unidadDeMedida);
    }

    // ACTUALIZAR UN DEPARTAMENTO
    public UnidadDeMedida actualizar(UnidadDeMedida unidadDeMedida){
        return repo.save(unidadDeMedida);
    }

    // ELIMINAR UN DEPARTAMENTO
    public void eliminar(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el cliente con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
