package com.aperegarc.SpringBoot.service;

import com.aperegarc.SpringBoot.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> getAllClientes();
    public Cliente saveCliente(Cliente cliente);
    public Cliente updateCliente(Integer id, Cliente nuevoCliente);
    public void deleteCliente(Integer id);
}
