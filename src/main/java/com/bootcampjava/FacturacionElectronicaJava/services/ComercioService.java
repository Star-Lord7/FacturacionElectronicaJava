package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.Comercio;
import com.bootcampjava.FacturacionElectronicaJava.repository.ComercioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService {

    private final ComercioRepository repo;

    public ComercioService(ComercioRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS DEPARTAMENTOS
    public List<Comercio> todosComercio(){
        return  repo.findAll();
    }

    // OBTENER UN DEPARTAMENTO
    public Comercio unComercio(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN DEPARTAMENTO
    public Comercio guardar(Comercio comercio){
        return repo.save(comercio);
    }

    // ACTUALIZAR UN DEPARTAMENTO
    public Comercio actualizar(Comercio comercio){
        return repo.save(comercio);
    }

    // ELIMINAR UN DEPARTAMENTO
    public void eliminar(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el cliente con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
