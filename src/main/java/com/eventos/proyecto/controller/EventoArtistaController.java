package com.eventos.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.proyecto.model.EventoArtista;
import com.eventos.proyecto.repository.EventoArtistaRepository;

import java.util.List;

@RestController
@RequestMapping("/evento-artista")
public class EventoArtistaController {

    @Autowired
    private EventoArtistaRepository eventoArtistaRepository;

    @PostMapping
    public EventoArtista crear(@RequestBody EventoArtista ea) {
        return eventoArtistaRepository.save(ea);
    }

    @GetMapping
    public List<EventoArtista> listar() {
        return eventoArtistaRepository.findAll();
    }
}