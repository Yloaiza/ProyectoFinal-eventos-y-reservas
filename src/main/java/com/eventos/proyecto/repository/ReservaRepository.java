package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.proyecto.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}