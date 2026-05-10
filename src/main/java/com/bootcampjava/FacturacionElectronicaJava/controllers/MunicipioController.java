package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.Municipio;
import com.bootcampjava.FacturacionElectronicaJava.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService servicio;

    @GetMapping
    public List<Municipio> listadoMunicipios(){
        return servicio.todosMunicipios();
    }

    @GetMapping("/{id}")
    public Municipio unMunicipio(@PathVariable Long id){
        return servicio.unMunicipio(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipio guardar(@RequestBody Municipio municipio){
        return servicio.guardar(municipio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        servicio.eliminarMunicipio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Municipio actualizar(@PathVariable Long id, @RequestBody Municipio municipio){
       municipio.setId(id);
       return servicio.actualizar(municipio);
    }

}
