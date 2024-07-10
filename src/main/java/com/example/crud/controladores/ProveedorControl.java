package com.example.crud.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.crud.entidades.Proveedor;
import com.example.crud.repositorioservicios.IProveedorServicios;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProveedorControl {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorControl.class);
    @Autowired
    private IProveedorServicios servicio;

    @GetMapping("/listarProveedor")
    public String mostrarListaProveedor(Model model) {

        try {
            List<Proveedor> proveedores = servicio.listar();
            model.addAttribute("proveedores", proveedores);
            logger.info("Listado de Proveedores obtenido con éxito.");
        } catch (Exception e) {
            // Logueo del error y adición de un mensaje de error al modelo.
            logger.error("Error al obtener el listado de Proveedores.", e);
            model.addAttribute("errorMensaje", "Error al obtener productos. Intente nuevamente más tarde.");
        }
        // Retorna el nombre de la vista 'index' que debe estar en la carpeta de
        // recursos de vistas.
        return "index";

    }

    @GetMapping("/Proveedor/crear")
    public String mostratFormulariocrear(Model model) {

        model.addAttribute("Proveedor", new Proveedor());
        return "FormularioProveedor"; // Nombre de la vista del formulario para crear producto
    }

    @PostMapping("/Proveedor/guardar")
    public String guardarProveedor(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Proveedor", proveedor);
            return "FormularioProveedor"; // Retornar a la vista del formulario si hay errores.
        }
        try {
            servicio.guardar(proveedor);
        } catch (Exception e) {
            logger.error("Error al guardar el proveedor.", e);
            model.addAttribute("errorMensaje", "Error al guardar el cliente. Intente nuevamente más tarde.");
            return "FormularioProveedor";
        }
        return "redirect:/listarProveedor";
    }



    
    @GetMapping("/proveedor/editar/{idProveedor}")
    public String mostrarFormularioEditar(@PathVariable Long idProveedor, Model model) {
        Optional<Proveedor> Proveedor = servicio.listarPorId(idProveedor);
        if (Proveedor.isPresent()) {
            model.addAttribute("proovedor", Proveedor.get());
            return "formularioProveedor";
        } else {
            return "redirect:/listarProveedor";
        }
    }

    @PostMapping("/proovedor/editar")
    public String actualizarCliente(@Valid @ModelAttribute("prooveedor") Proveedor proveedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proveedor", proveedor);
            return "formularioProveedor";
        }
        try {
            servicio.guardar(proveedor);
        } catch (Exception e) {
            logger.error("Error al actualizar el proveedor.", e);
            model.addAttribute("errorMensaje", "Error al actualizar el proovedor. Intente nuevamente más tarde.");
            return "formularioProveedor";
        }
        return "redirect:/listarProveedor";
    }

    @GetMapping("/provedoor/eliminar/{idProveedor}")
    public String eliminarProveedor(@PathVariable Long idProveedor) {
        try {
            servicio.eliminar(idProveedor);
        } catch (Exception e) {
            logger.error("Error al eliminar el proovedor.", e);
        }
        return "redirect:/listarProveedor";
    }
}




