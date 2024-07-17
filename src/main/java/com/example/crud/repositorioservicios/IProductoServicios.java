package com.example.crud.repositorioservicios;

import java.util.List;
import java.util.Optional;
import com.example.crud.entidades.Producto;

public interface IProductoServicios {

    List<Producto> listar();

    Optional <Producto> listarPorId(long idProducto);
 
    
    Producto guardarProducto(Producto producto);

    void eliminarProducto(Long idProducto);
}
