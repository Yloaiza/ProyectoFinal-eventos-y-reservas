package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventos.proyecto.model.EventoArtista;

public interface EventoArtistaRepository extends JpaRepository<EventoArtista, Long> {
}