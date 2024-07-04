package com.example.crud.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entidades.Producto;
import com.example.crud.repositorioservicios.IProductoServicios;
import com.example.crud.repositorio.RepositorioProducto;

@Service
public class ServiciosProductos implements IProductoServicios {

    @Autowired
    private RepositorioProducto data;

    @Override
    public List<Producto> listar() {
        return data.findAll();
    }

    @Override
    public Optional<Producto> findById(Long idProducto) {
        return data.findById(idProducto);
    }

    @Override
    public Optional<Producto> listarId(Long idProducto) {
        return data.findById(idProducto); // Devuelve Optional<Producto>
    }

    @Override
    public Producto save(Producto producto) {
        try {
            return data.save(producto);
        } catch (Exception e) {
            System.err.println("Error al guardar el producto: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Long idProducto) {
        data.deleteById(idProducto);
    }
}

