package com.eventos.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;
    private String nombre;
    private String tipo;
    private Date fecha;
    private String hora;
    private Double precio;
    private int cupoDisponible;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUbicacion")
    private Ubicacion ubicacion;
}
