package com.example.crud.repositorioservicios;

import java.util.List;
import java.util.Optional;
import com.example.crud.entidades.Proveedor;

public interface IProveedorServicios {
    List<Proveedor> listar();

    Optional<Proveedor> listarPorId(long idProveedor);

    Proveedor guardar(Proveedor proveedor);

    void eliminar(long idProveedor);

}
