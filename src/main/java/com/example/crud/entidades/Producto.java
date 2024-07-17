package com.example.crud.entidades;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProducto",nullable=false)
    private Long idProducto;

    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;

    @Column(name = "descripcion" ,nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "categoria", nullable=false)
    private String categoria;

    @Column (name="cantidad",nullable=false)
    private BigDecimal cantidad;
}
