package com.eventos.proyecto.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private Integer cupoDisponible;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUbicacion")
    private Ubicacion ubicacion;
    @OneToMany(mappedBy = "evento")
    @JsonManagedReference
    private List<EventoArtista> eventoArtistas;
}
