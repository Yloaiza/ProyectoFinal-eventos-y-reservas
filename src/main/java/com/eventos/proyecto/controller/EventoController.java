package com.eventos.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.proyecto.model.Evento;
import com.eventos.proyecto.repository.EventoRepository;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public Evento crear(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }
}