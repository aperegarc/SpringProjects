package com.aperegarc.SpringBoot.controllers;

import com.aperegarc.SpringBoot.entity.Cliente;
import com.aperegarc.SpringBoot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    // @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> listarClientes() {
        return clienteService.getAllClientes();
    }


    // @GetMapping("/{username}")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Cliente getCliente(@PathVariable String username) {
        for (Cliente cliente : clienteService.getAllClientes()) {
            if (cliente.getUsername().equalsIgnoreCase(username)) {
                return cliente;
            }
        }
        return null;
    }


    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Cliente nuevoCliente) {
        clienteService.saveCliente(nuevoCliente);
        return ResponseEntity.ok(nuevoCliente);
    }


    // @PutMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Cliente putCliente(@PathVariable Integer id, @RequestBody Cliente nuevoCliente){
        return clienteService.updateCliente(id, nuevoCliente);
    }

    // @DeleteMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Cliente> deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
        return clienteService.getAllClientes();
    }


}
