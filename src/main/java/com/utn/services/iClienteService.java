/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utn.services;

import com.utn.dto.ClienteDTO;
import com.utn.models.Cliente;
import java.util.List;


public interface iClienteService {
    
    public List<ClienteDTO> verClientes();
    public void crearCliente(Cliente cliente);
    public void borrarCliente(Long id);
    public Cliente buscarCliente(Long id);
    public Cliente findByDni(int dni);
    
}
