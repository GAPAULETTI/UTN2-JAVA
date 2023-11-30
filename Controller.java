/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utn.controllers;

import com.utn.dto.CategoriaDTO;
import com.utn.dto.ClienteDTO;
import com.utn.dto.OrdenDTO;
import com.utn.dto.TecnicoDTO;
import com.utn.models.Cliente;
import com.utn.models.Orden;
import com.utn.models.Tecnico;
import com.utn.repositories.OrdenRepo;
import com.utn.services.CategoriaService;
import com.utn.services.ClienteService;
import com.utn.services.TecnicoService;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gaston
 */
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    ClienteService clienteService;
    @Autowired
    TecnicoService tecnicoService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    OrdenRepo repoOrden;
    
    @GetMapping("/cliente")
    public List<ClienteDTO> getClientes(){
     return clienteService.verClientes();
    }
    @GetMapping("/tecnico")
    public List<TecnicoDTO> getTecnico(){
        return tecnicoService.verTecnicos();
    }
    @GetMapping("/tecnico/{id}")
    public Tecnico getTecnicoById(@PathVariable Long id ){
        return tecnicoService.buscarTecnico(id);
    }
    @GetMapping("/categorias")
    public List<CategoriaDTO> getCategorias(){
     return categoriaService.verCategorias();
    }
    
    @PostMapping("/nueva/orden")
    public ResponseEntity<Object> crearOrden(@RequestBody OrdenDTO data){
        if(data.getCliente() == null){
            return new ResponseEntity<>("Agregar Cliente", HttpStatus.FORBIDDEN);
        }
        
        Orden orden = new Orden(data.getDescripcion(), data.getCosto(), LocalDateTime.now(), data.getEstado());
       return new ResponseEntity<>("Orden Creada", HttpStatus.CREATED);
        }
    
}
