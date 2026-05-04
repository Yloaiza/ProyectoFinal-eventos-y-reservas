package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.proyecto.model.Artista;

public interface ArtistaRespository extends JpaRepository<Artista, Long> {
}