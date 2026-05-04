package com.eventos.proyecto.services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventos.proyecto.model.*;
import com.eventos.proyecto.repository.ReservaRepository;
import com.eventos.proyecto.repository.EventoRepository;
import com.eventos.proyecto.repository.UsuarioRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Reserva crearReserva(Long idUsuario, Long idEvento, int cantidad) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (usuario == null || evento == null) {
            throw new RuntimeException("Usuario o evento no encontrado");
        }
        if (evento.getCupoDisponible() < cantidad) {
            throw new RuntimeException("No hay suficientes cupos disponibles");
        }
        // Descontar cupos
        evento.setCupoDisponible(evento.getCupoDisponible() - cantidad);
        eventoRepository.save(evento);
        // Crear reserva
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setEvento(evento);
        reserva.setCantidadEntradas(cantidad);
        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setEstado("ACTIVA");
        return reservaRepository.save(reserva);
    }

}