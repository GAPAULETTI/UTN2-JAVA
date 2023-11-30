
package com.utn.dto;

import com.utn.models.Orden;
import com.utn.models.Tecnico;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class TecnicoDTO {
    
    private Long id;
    private String nombre;
    private int telefono;
    private Set<CategoriaDTO> servicios = new HashSet<>();
    private Orden orden;
    
    public TecnicoDTO(){};

    public TecnicoDTO(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nombre = tecnico.getNombre();
        this.telefono = tecnico.getTelefono();
        this.servicios = tecnico.getServicios().stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toSet());
    }
    
    
}
