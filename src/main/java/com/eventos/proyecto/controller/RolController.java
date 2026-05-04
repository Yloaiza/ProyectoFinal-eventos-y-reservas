package com.eventos.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventos.proyecto.model.Rol;
import com.eventos.proyecto.repository.RolRepository;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    // Crear rol
    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    // Listar roles
    @GetMapping
    public List<Rol> listar() {
        return rolRepository.findAll();
    }
}