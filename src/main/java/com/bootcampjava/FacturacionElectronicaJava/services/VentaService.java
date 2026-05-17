package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.DetalleVenta;
import com.bootcampjava.FacturacionElectronicaJava.models.Venta;
import com.bootcampjava.FacturacionElectronicaJava.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository repo;

    public VentaService(VentaRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LAS VENTAS
    public List<Venta> listadoVentas(){
        return  repo.findAll();
    }

    // OBTENER UNA VENTA
    public Venta unaVenta(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UNA VENTA
    public Venta guardar(Venta venta){
        // Asignar la referencia de la venta a cada detalleVenta
        if (venta.getDetallesVenta() != null) {
            for (DetalleVenta detalleVenta : venta.getDetallesVenta()) {
                detalleVenta.setVentas(venta); // ← clave
            }
        }
        return repo.save(venta);
    }

    // ACTUALIZAR UNA VENTA
    public Venta actualizar(Venta venta) {
        return repo.save(venta);
    }

}
