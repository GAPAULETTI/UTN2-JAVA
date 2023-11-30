/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utn.services;

import com.utn.dto.CategoriaDTO;
import com.utn.models.Categoria;
import java.util.List;

/**
 *
 * @author Gaston
 */
public interface iCategoriaService {
    
    public List<CategoriaDTO> verCategorias();
    public void crearCategoria(Categoria cliente);
    public void borrarCategoria(Long id);
    public Categoria buscarCategoria(Long id);
}
