
package com.utn.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private int telefono;
    
    @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
    private Set<Categoria> servicios;
    
    @ManyToOne(fetch = FetchType.EAGER)
    
    private Orden orden;

    public Tecnico() {
    }

    public Tecnico(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.servicios = new HashSet<>();
    }
    
    public void addCategoria(Categoria categoria){
     categoria.setTecnico(this);
     servicios.add(categoria);
    }
    
    
}
