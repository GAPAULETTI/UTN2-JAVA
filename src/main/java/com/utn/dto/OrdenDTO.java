
package com.utn.dto;

import com.utn.models.Cliente;
import com.utn.models.Orden;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class OrdenDTO {
    
    private Long id;
     private String descripcion;
     private Double costo;
     private LocalDateTime fechaOrden;
     private String estado;
     
     private Cliente cliente;
    
     private List<TecnicoDTO> tecnicoAsignado;
     
     private Set<CategoriaDTO> categoriaIncidencia = new HashSet<>();

    public OrdenDTO(Orden orden) {
        this.id = orden.getId();
        this.descripcion = orden.getDescripcion();
        this.costo = orden.getCosto();
        this.fechaOrden = orden.getFechaOrden();
        this.estado = orden.getEstado();
        this.tecnicoAsignado = orden.getTecnico().stream().map(tecnico -> new TecnicoDTO(tecnico)).collect(Collectors.toList());
        this.categoriaIncidencia = orden.getCategoria().stream().map(cat -> new CategoriaDTO(cat)).collect(Collectors.toSet());
        
    }
     
     
}
