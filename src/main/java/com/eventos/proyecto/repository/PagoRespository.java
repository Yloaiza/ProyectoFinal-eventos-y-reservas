package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.proyecto.model.Pago;

public interface PagoRespository extends JpaRepository<Pago, Long> {
}