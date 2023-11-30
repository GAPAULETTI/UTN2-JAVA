
package com.utn.dto;

import com.utn.models.Cliente;
import java.util.List;
import lombok.Getter;

@Getter
public class ClienteDTO {
     private Long id;
 
    private int dni;
    private String nombre;
    private String direccion;
    private String email;
    private List<OrdenDTO> orden;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.dni = cliente.getDni();
        this.nombre = cliente.getNombre();
        this.direccion = cliente.getDireccion();
        this.email = cliente.getEmail();
    }
    
    
}
