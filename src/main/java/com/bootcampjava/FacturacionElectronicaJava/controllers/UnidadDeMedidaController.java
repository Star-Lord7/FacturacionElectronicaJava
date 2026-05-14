package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.Cliente;
import com.bootcampjava.FacturacionElectronicaJava.models.UnidadDeMedida;
import com.bootcampjava.FacturacionElectronicaJava.services.ClienteService;
import com.bootcampjava.FacturacionElectronicaJava.services.UnidadDeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/medida")
public class UnidadDeMedidaController {

    @Autowired
    private UnidadDeMedidaService servicio;

    @GetMapping
    public List<UnidadDeMedida> listadoClientes(){
        return servicio.todasUnidadesDeMedida();
    }

    @GetMapping("/{id}")
    public UnidadDeMedida unCliente(@PathVariable Long id){
        return servicio.unaUnidadDeMedida(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UnidadDeMedida guardar(@RequestBody UnidadDeMedida unidadDeMedida){
        return servicio.guardar(unidadDeMedida);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UnidadDeMedida actualizar(@PathVariable Long id, @RequestBody UnidadDeMedida unidadDeMedida){
        unidadDeMedida.setId(id);
        return servicio.actualizar(unidadDeMedida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
