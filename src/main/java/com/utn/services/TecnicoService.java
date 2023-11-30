/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utn.services;

import com.utn.dto.TecnicoDTO;
import com.utn.models.Tecnico;
import com.utn.repositories.TecnicoRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TecnicoService implements iTecnicoService{
    
    @Autowired
    public TecnicoRepo tecnicoRepo;

    @Override
    public List<TecnicoDTO> verTecnicos() {
        return tecnicoRepo.findAll().stream().map(tecnico -> new TecnicoDTO(tecnico)).collect(Collectors.toList());
    }

    @Override
    public void crearTecnico(Tecnico tecnico) {
        tecnicoRepo.save(tecnico);
    }

    @Override
    public void borrarTecnico(Long id) {
        tecnicoRepo.deleteById(id);
    }

    @Override
    public Tecnico buscarTecnico(Long id) {
        return tecnicoRepo.findById(id).orElse(null);
    }
    
}
