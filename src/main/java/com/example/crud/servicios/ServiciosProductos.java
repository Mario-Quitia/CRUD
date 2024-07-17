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
    public Optional<Producto> listarPorId(long idProducto) {
        return data.findById(idProducto);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        Producto productoGuardado=data.save(producto);
        return productoGuardado;
    }

    @Override
    public void eliminarProducto(Long idProducto) {
       data.deleteById(idProducto);
    }

   
}

