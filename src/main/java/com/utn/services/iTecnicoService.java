/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utn.services;

import com.utn.dto.TecnicoDTO;
import com.utn.models.Tecnico;
import java.util.List;

/**
 *
 * @author Gaston
 */
public interface iTecnicoService {
    
    public List<TecnicoDTO> verTecnicos();
    public void crearTecnico(Tecnico cliente);
    public void borrarTecnico(Long id);
    public Tecnico buscarTecnico(Long id);
}
