package com.example.crud.repositorio;
import com.example.crud.entidades.Proveedor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RepositorioProveedor extends JpaRepository <Proveedor,Long>{
    

    Optional <Proveedor> findById (long idProveedor);
}
