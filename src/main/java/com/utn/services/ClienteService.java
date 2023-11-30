/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utn.services;

import com.utn.dto.ClienteDTO;
import com.utn.models.Cliente;
import com.utn.repositories.ClienteRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements iClienteService {
    
    @Autowired
    public ClienteRepo clienteRepo;

    @Override
    public List<ClienteDTO> verClientes() {
            return clienteRepo.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
        }

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void borrarCliente(Long id) {
     clienteRepo.deleteById(id);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }    

    @Override
    public Cliente findByDni(int dni) {
        return clienteRepo.findByDni(dni);
    }
    
}
