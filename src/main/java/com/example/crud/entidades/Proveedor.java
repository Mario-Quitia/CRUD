 package com.example.crud.entidades;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProveedor;

    @Column(name = "nombreProveedor", nullable = false)
    private String nombreProveedor;

    @Column(name = "nombredeContacto", nullable = false)
    private String nombredeContacto;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column (name="celular" ,nullable=false)
    private String celular;

    @Column (name="ciudad" ,nullable=false)
    private String ciudad;

}
 