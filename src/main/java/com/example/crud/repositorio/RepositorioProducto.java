package com.example.crud.repositorio;

import com.example.crud.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
   

    Optional<Producto> findById(Long idProducto);
}
