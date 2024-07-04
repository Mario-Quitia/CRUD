package com.example.crud.servicios;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.entidades.Cliente;
import com.example.crud.repositorioservicios.IClientesServicios;
import com.example.crud.repositorio.RepositorioClientes;

@Service

public class ServiciosClientes implements IClientesServicios {

    @Autowired
    private RepositorioClientes data;

    @Override
    public List<Cliente> listar() {
        return  data.findAll();
    }

    @Override
    public Optional<Cliente> listarPorId(long idCliente) {
      return data.findById(null);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        Cliente clienteGuardado = data.save(cliente);
        return clienteGuardado;
    }
    

    @Override
    public void eliminar(long idCliente) {
        data.deleteById(idCliente);
       
    }

}
