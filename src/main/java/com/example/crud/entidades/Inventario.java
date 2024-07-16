package com.example.crud.entidades;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Inventario")


public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipoMovimiento", nullable = false)
    private String tipoMovimiento; // "entrada" o "salida"

    @Column(name = "fechaMovimiento", nullable = false)
    private LocalDateTime fechaMovimiento;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = true)
    private Proveedor proveedor;

}
