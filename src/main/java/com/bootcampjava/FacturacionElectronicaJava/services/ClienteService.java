package com.bootcampjava.FacturacionElectronicaJava.services;

import com.bootcampjava.FacturacionElectronicaJava.models.Cliente;
import com.bootcampjava.FacturacionElectronicaJava.models.Municipio;
import com.bootcampjava.FacturacionElectronicaJava.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODOS LOS CLEINTES
    public List<Cliente> todosClientes(){
        return  repo.findAll();
    }

    // OBTENER UN CLIENTE
    public Cliente unCliente(Long id){
        return  repo.findById(id).get();
    }

    // CREAR UN CLIENTE
    public Cliente guardar(Cliente cliente){
        return repo.save(cliente);
    }

    // ACTUALIZAR UN CLIENTE
    public Cliente actualizar(Cliente cliente){
        return repo.save(cliente);
    }

    // ELIMINAR UN CLIENTE
    public void eliminar(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("No se encontro el cliente con el ID: " + id);
        }
        repo.deleteById(id);
    }

}
