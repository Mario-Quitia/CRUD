package com.example.crud.repositorioservicios;

import java.util.List;
import java.util.Optional;

import com.example.crud.entidades.Cliente;

public interface IClientesServicios {

    List<Cliente> listar();

    Optional<Cliente> listarPorId(long idCliente);

    Cliente guardar(Cliente cliente);

    void eliminar(long idCliente);

}
