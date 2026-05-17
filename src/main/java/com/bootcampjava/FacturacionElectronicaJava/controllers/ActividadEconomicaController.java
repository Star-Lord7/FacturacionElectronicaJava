package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.ActividadEconomica;
import com.bootcampjava.FacturacionElectronicaJava.services.ActividadEconomicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/actividadEconomica")
public class ActividadEconomicaController {

    @Autowired
    private ActividadEconomicaService servicio;

    @GetMapping
    public List<ActividadEconomica> listadoActividadEconomica(){
        return servicio.todasActividadEconomica();
    }

    @GetMapping("/{id}")
    public ActividadEconomica unaActividadEconomica(@PathVariable Long id){
        return servicio.unaActividadEconomica(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadEconomica guardar(@RequestBody ActividadEconomica actividadEconomica){
        return servicio.guardar(actividadEconomica);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActividadEconomica actualizar(@PathVariable Long id, @RequestBody ActividadEconomica actividadEconomica){
        actividadEconomica.setId(id);
        return servicio.actualizar(actividadEconomica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
