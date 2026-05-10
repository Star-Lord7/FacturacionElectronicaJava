package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.Departamento;
import com.bootcampjava.FacturacionElectronicaJava.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService servicio;

    @GetMapping
    public List<Departamento> listadoDepartamentos(){
        return servicio.todosDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamento unDepartamento(@PathVariable Long id){
        return servicio.unDepartamento(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento guardar(@RequestBody Departamento departamento){
        return servicio.guardar(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        servicio.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Departamento actualizar(@PathVariable Long id, @RequestBody Departamento departamento){
       departamento.setId(id);
       return servicio.actualizar(departamento);
    }

}
