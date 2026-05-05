package com.eventos.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.proyecto.model.Artista;
import com.eventos.proyecto.repository.ArtistaRepository;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    // Crear artista
    @PostMapping
    public Artista crear(@RequestBody Artista artista) {
        return artistaRepository.save(artista);
    }

    // Listar artistas
    @GetMapping
    public List<Artista> listar() {
        return artistaRepository.findAll();
    }
}