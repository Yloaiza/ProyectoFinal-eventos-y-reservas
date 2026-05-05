package com.eventos.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventos.proyecto.repository.UbicacionRepository;
import com.eventos.proyecto.model.Ubicacion;
import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @PostMapping
    public Ubicacion crear(@RequestBody Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @GetMapping
    public List<Ubicacion> listar() {
        return ubicacionRepository.findAll();
    }
}