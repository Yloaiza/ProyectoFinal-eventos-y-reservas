package com.eventos.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

        @Id
    private Long cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;
}
