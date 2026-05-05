package com.eventos.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventos.proyecto.model.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
}