package com.eventos.proyecto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pago {

        @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idPago;

    private Date fechaPago;

    private double monto;

    private String metodoPago;

    @OneToOne

    @JoinColumn(name = "idReserva")

    private Reserva reserva;
}
