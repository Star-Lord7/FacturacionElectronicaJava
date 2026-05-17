package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.Comercio;
import com.bootcampjava.FacturacionElectronicaJava.services.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/comercio")
public class ComercioController {

    @Autowired
    private ComercioService servicio;

    @GetMapping
    public List<Comercio> listadoComercio(){
        return servicio.todosComercio();
    }

    @GetMapping("/{id}")
    public Comercio unComercio(@PathVariable Long id){
        return servicio.unComercio(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comercio guardar(@RequestBody Comercio comercio){
        return servicio.guardar(comercio);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comercio actualizar(@PathVariable Long id, @RequestBody Comercio comercio){
        comercio.setId(id);
        return servicio.actualizar(comercio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
