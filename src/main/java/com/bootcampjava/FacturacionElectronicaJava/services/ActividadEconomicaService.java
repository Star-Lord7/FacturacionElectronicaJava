package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.ActividadEconomica;
import com.bootcampjava.FacturacionElectronicaJava.repository.ActividadEconomicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadEconomicaService {

    private final ActividadEconomicaRepository repo;

    public ActividadEconomicaService(ActividadEconomicaRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS DEPARTAMENTOS
    public List<ActividadEconomica> todasActividadEconomica(){
        return  repo.findAll();
    }

    // OBTENER UN DEPARTAMENTO
    public ActividadEconomica unaActividadEconomica(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN DEPARTAMENTO
    public ActividadEconomica guardar(ActividadEconomica actividadEconomica){
        return repo.save(actividadEconomica);
    }

    // ACTUALIZAR UN DEPARTAMENTO
    public ActividadEconomica actualizar(ActividadEconomica actividadEconomica){
        return repo.save(actividadEconomica);
    }

    // ELIMINAR UN DEPARTAMENTO
    public void eliminar(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el cliente con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
