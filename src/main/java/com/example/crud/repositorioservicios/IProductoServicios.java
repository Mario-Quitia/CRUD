package com.example.crud.repositorioservicios;

import java.util.List;
import java.util.Optional;
import com.example.crud.entidades.Producto;

public interface IProductoServicios {

    List<Producto> listar();

    Optional<Producto> findById(Long idProducto);

    Optional<Producto> listarId(Long idProducto);

    Producto save(Producto producto);

    void delete(Long idProducto);
}
