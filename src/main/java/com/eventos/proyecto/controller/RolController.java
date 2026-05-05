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

    // Actualizar rol
    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Long id, @RequestBody Rol rolActualizado) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rol.setNombre(rolActualizado.getNombre());
        return rolRepository.save(rol);
    }
    // Eliminar rol
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rolRepository.deleteById(id);
    }
    // Obtener rol por ID
    @GetMapping("/{id}")
    public Rol obtenerPorId(@PathVariable Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }
}