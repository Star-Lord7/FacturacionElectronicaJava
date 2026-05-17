package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.Producto;
import com.bootcampjava.FacturacionElectronicaJava.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService servicio;

    @GetMapping
    public List<Producto> listadoComercio(){
        return servicio.listadoProducto();
    }

    @GetMapping("/{id}")
    public Producto unComercio(@PathVariable Long id){
        return servicio.unProducto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardar(@RequestBody Producto producto){
        return servicio.guardar(producto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto){
        producto.setId(id);
        return servicio.actualizar(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
