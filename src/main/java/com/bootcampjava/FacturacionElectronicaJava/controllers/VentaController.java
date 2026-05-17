package com.bootcampjava.FacturacionElectronicaJava.controllers;

import com.bootcampjava.FacturacionElectronicaJava.models.Venta;
import com.bootcampjava.FacturacionElectronicaJava.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/venta")
public class VentaController {

    @Autowired
    private VentaService servicio;

    @GetMapping
    public List<Venta> listadoComercio(){
        return servicio.listadoVentas();
    }

    @GetMapping("/{id}")
    public Venta unComercio(@PathVariable Long id){
        return servicio.unaVenta(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venta guardar(@RequestBody Venta venta){
        return servicio.guardar(venta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Venta actualizar(@PathVariable Long id, @RequestBody Venta venta){
        venta.setId(id);
        return servicio.actualizar(venta);
    }

}
