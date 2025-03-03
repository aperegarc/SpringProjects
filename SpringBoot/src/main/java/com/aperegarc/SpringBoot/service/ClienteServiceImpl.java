package com.aperegarc.SpringBoot.service;


import com.aperegarc.SpringBoot.entity.Cliente;
import com.aperegarc.SpringBoot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente nuevoCliente) {
        Cliente cliente = clienteRepository.findById(id).get();
        if(nuevoCliente.getName() != null || nuevoCliente.getName() != ""){
            cliente.setName(nuevoCliente.getName());
        }
        if(nuevoCliente.getUsername() != null || nuevoCliente.getUsername() != ""){
            cliente.setUsername(nuevoCliente.getUsername());
        }
        if(nuevoCliente.getPassword() != null || nuevoCliente.getPassword() != ""){
            cliente.setPassword(nuevoCliente.getPassword());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }


}
