package com.example.crud.repositorio;

import com.example.crud.entidades.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long idCliente);
}



