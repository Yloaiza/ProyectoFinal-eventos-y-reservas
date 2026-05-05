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

    @PostMapping //crear ubicacion
    public Ubicacion crear(@RequestBody Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @GetMapping //listar ubicaciones
    public List<Ubicacion> listar() {
        return ubicacionRepository.findAll();
    }
    @PutMapping("/{id}") //actualizar ubicacion
    public Ubicacion actualizar(@PathVariable Long id, @RequestBody Ubicacion ubicacionActualizada) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ubicacion no encontrada"));
        ubicacion.setNombreLugar(ubicacionActualizada.getNombreLugar());
        ubicacion.setDireccion(ubicacionActualizada.getDireccion());
        ubicacion.setCiudad(ubicacionActualizada.getCiudad());
        ubicacion.setCapacidad(ubicacionActualizada.getCapacidad());
        return ubicacionRepository.save(ubicacion);
    }
    @GetMapping("/{id}") //obtener ubicacion por id
    public Ubicacion obtenerPorId(@PathVariable Long id) {
        return ubicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ubicacion no encontrada"));
    }
    @DeleteMapping("/{id}") //eliminar ubicacion
    public void eliminar(@PathVariable Long id) {
        ubicacionRepository.deleteById(id);
    }
}