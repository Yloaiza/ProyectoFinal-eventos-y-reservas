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
    // Actualizar artista
    @PutMapping("/{id}")
    public Artista actualizar(@PathVariable Long id, @RequestBody Artista artistaActualizado) {
        Artista artista = artistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado"));
        artista.setNombre(artistaActualizado.getNombre());
        artista.setTipo(artistaActualizado.getTipo());
        artista.setDescripcion(artistaActualizado.getDescripcion());
        return artistaRepository.save(artista);
    }
    // Eliminar artista
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        artistaRepository.deleteById(id);
    }

}