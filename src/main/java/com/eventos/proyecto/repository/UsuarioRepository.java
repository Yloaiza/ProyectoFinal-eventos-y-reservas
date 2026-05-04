package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}