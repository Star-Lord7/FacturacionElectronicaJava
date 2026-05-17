package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.Producto;
import com.bootcampjava.FacturacionElectronicaJava.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS PRODUCTOS
    public List<Producto> listadoProducto(){
        return  repo.findAll();
    }

    // OBTENER UN PRODUCTOS
    public Producto unProducto(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN PRODUCTOS
    public Producto guardar(Producto producto){
        return repo.save(producto);
    }

    // ACTUALIZAR UN PRODUCTOS
    public Producto actualizar(Producto producto){
        return repo.save(producto);
    }

    // ELIMINAR UN PRODUCTO
    public void eliminar(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el producto con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
