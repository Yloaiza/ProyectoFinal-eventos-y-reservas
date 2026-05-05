package com.eventos.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping //crear evento
    public Evento crear(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping //listar
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @PutMapping("/{id}") //update
    public Evento actualizar(@PathVariable Long id, @RequestBody Evento eventoActualizado) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        evento.setNombre(eventoActualizado.getNombre());
        evento.setTipo(eventoActualizado.getTipo());
        evento.setFecha(eventoActualizado.getFecha());
        evento.setHora(eventoActualizado.getHora());
        evento.setPrecio(eventoActualizado.getPrecio());
        evento.setCupoDisponible(eventoActualizado.getCupoDisponible());
        evento.setDescripcion(eventoActualizado.getDescripcion());
        evento.setUbicacion(eventoActualizado.getUbicacion());

        return eventoRepository.save(evento);
    }

    @DeleteMapping("/{id}") //delete
    public void eliminar(@PathVariable Long id) {
        eventoRepository.deleteById(id);
    }

    @GetMapping("/{id}")  //buscar por id
    public Evento obtenerPorId(@PathVariable Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }
}