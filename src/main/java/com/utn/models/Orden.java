
package com.utn.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String descripcion;
     private Double costo;
     private LocalDateTime fechaOrden;
     private String estado;
     
     
     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "Id_Cliente")
     private Cliente cliente;
     
     @OneToMany(mappedBy = "orden",fetch = FetchType.EAGER)
     private List<Tecnico> tecnico;
     
     @OneToMany(mappedBy = "orden",fetch = FetchType.EAGER)
     private Set<Categoria> categoria;
    
     public Orden() {
    }

    public Orden(String descripcion, Double costo, LocalDateTime fechaOrden, String estado) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaOrden = fechaOrden;
        this.estado = estado;
        this.tecnico = new ArrayList<>();
        this.categoria = new HashSet<>();
    }
   
    public void addTecnico(Tecnico tecnico){
     this.tecnico.add(tecnico);
    }
    public void addCategoria(Categoria categoria){
     this.categoria.add(categoria);
    }
             
}
