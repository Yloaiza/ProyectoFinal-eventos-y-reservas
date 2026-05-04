package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.proyecto.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}