package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.Departamento;
import com.bootcampjava.FacturacionElectronicaJava.models.Municipio;
import com.bootcampjava.FacturacionElectronicaJava.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repo;

    public DepartamentoService(DepartamentoRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS DEPARTAMENTOS
    public List<Departamento> todosDepartamentos(){
        return  repo.findAll();
    }

    // OBTENER UN DEPARTAMENTO
    public Departamento unDepartamento(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN DEPARTAMENTO
    public Departamento guardar(Departamento departamento){
        // Asignar la referencia del departamento a cada municipio
        if (departamento.getMunicipios() != null) {
            for (Municipio municipio : departamento.getMunicipios()) {
                municipio.setDepartamento(departamento); // ← clave
            }
        }
        return repo.save(departamento);
    }

    // ACTUALIZAR UN DEPARTAMENTO
    public Departamento actualizar(Departamento departamento) {
        // Asignar la referencia del departamento a cada municipio
        if (departamento.getMunicipios() != null) {
            for (Municipio municipio : departamento.getMunicipios()) {
                municipio.setDepartamento(departamento); // ← clave
            }
        }
        return repo.save(departamento);
    }

    // ELIMINAR UN DEPARTAMENTO
    public void eliminarDepartamento(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el departamento con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
