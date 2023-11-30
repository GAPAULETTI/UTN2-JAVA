
package com.utn.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private int dni;
    private String nombre;
    private String direccion;
    private String email;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Orden> orden;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String direccion, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.orden = new ArrayList<>();
    }
    
    public void addOrden(Orden orden){
     this.orden.add(orden);
    }
    
   
}
