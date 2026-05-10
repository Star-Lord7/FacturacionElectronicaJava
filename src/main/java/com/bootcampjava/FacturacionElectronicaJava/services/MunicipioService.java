package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.Municipio;
import com.bootcampjava.FacturacionElectronicaJava.repository.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    private final MunicipioRepository repo;

    public MunicipioService(MunicipioRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS DEPARTAMENTOS
    public List<Municipio> todosMunicipios(){
        return  repo.findAll();
    }

    // OBTENER UN DEPARTAMENTO
    public Municipio unMunicipio(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN DEPARTAMENTO
    public Municipio guardar(Municipio municipio){
        return repo.save(municipio);
    }

    // ACTUALIZAR UN DEPARTAMENTO
    public Municipio actualizar(Municipio municipio) {
        return repo.save(municipio);
    }

    // ELIMINAR UN DEPARTAMENTO
    public void eliminarMunicipio(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el municipio con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
