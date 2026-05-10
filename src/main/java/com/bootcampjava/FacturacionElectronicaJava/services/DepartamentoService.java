package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.Departamento;
import com.bootcampjava.FacturacionElectronicaJava.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repo;

    public DepartamentoService(DepartamentoRepository repo) {
        this.repo = repo;
    }

    public List<Departamento> todosDepartamentos(){
        return  repo.findAll();
    }

    public Departamento guardar(Departamento departamento){
        return repo.save(departamento);
    }

    public void eliminarDepartamento(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el departamento con el ID: " + id);
        }
        repo.deleteById(id);
    }
}
