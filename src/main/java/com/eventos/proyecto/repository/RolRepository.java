package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventos.proyecto.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}