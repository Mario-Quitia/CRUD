package com.example.crud.servicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.entidades.Proveedor;
import com.example.crud.repositorioservicios.IProveedorServicios;
import com.example.crud.repositorio.RepositorioProveedor;


@Service
public class ServicioProveedor implements IProveedorServicios{
  
@Autowired 
private RepositorioProveedor data;

    @Override
    public List<Proveedor> listar() {
       return data.findAll();
    }

    @Override
    public Optional<Proveedor> listarPorId(long idProveedor) {
        return data.findById(idProveedor);
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
       Proveedor proveedorGuardado=data.save(proveedor);
       return proveedorGuardado;
    }

    @Override
    public void eliminar(long idProveedor) {
        data.deleteById(idProveedor);
       
    }

}
