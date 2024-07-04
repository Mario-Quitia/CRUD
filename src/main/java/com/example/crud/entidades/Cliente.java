package com.example.crud.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente", nullable = false)
    private Long idCliente;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    @Column(name="celular", nullable = false)
    private String celular;

    @Column(name="direccion", nullable = false)
    private String direccion;
}

