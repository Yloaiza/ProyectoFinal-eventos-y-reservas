package com.eventos.proyecto.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.proyecto.model.Reserva;
import com.eventos.proyecto.services.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping // Endpoint para crear una reserva
    public Reserva reservar(
            @RequestParam Long idUsuario,
            @RequestParam Long idEvento,
            @RequestParam int cantidad) {

        return reservaService.crearReserva(idUsuario, idEvento, cantidad);
    }
    
}