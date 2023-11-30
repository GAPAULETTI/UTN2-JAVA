/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utn.dto;

import com.utn.models.Categoria;
import com.utn.models.Orden;
import com.utn.models.Tecnico;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
@Getter
public class CategoriaDTO {
    
    private Long id; 
    private String nombre;
    private String descripcion;
    private Tecnico tecnico;
    private Orden orden;
    
    public CategoriaDTO(){};

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
        this.descripcion = categoria.getDescripcion();
        
    }
    
    
    
}
