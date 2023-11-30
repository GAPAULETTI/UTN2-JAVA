
package com.utn.services;

import com.utn.dto.CategoriaDTO;
import com.utn.models.Categoria;
import com.utn.repositories.CategoriaRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements iCategoriaService{
    @Autowired
    public CategoriaRepo repoCat;

    @Override
    public List<CategoriaDTO> verCategorias() {
           return repoCat.findAll().stream().map(cat -> new CategoriaDTO(cat)).collect(Collectors.toList());
    }

    @Override
    public void crearCategoria(Categoria cat) {
      repoCat.save(cat);
    }
    @Override
    public void borrarCategoria(Long id) {
        repoCat.deleteById(id);
    }
    @Override
    public Categoria buscarCategoria(Long id) {
     return repoCat.findById(id).orElse(null);
    }
}
