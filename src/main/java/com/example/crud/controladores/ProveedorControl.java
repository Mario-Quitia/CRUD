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
            logger.error("Error al obtener el listado de Proveedores.", e);
            model.addAttribute("errorMensaje", "Error al obtener proveedores. Intente nuevamente más tarde.");
        }
        return "index";
    }

    @GetMapping("/Proveedor/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "FormularioProveedor";
    }

    @PostMapping("/Proveedor/guardar")
    public String guardarProveedor(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proveedor", proveedor);
            return "FormularioProveedor";  // Retornar a la vista del formulario si hay errores.
        }
        try {
            servicio.guardarProveedor(proveedor);
        } catch (Exception e) {
            logger.error("Error al guardar el proveedor.", e);
            model.addAttribute("errorMensaje", "Error al guardar el proveedor. Intente nuevamente más tarde.");
            return "FormularioProveedor";
        }
        return "redirect:/listarProveedor";
    }

    @GetMapping("/Proveedor/editar/{idProveedor}")
    public String mostrarFormularioEditar(@PathVariable Long idProveedor, Model model) {
        Optional<Proveedor> proveedor = servicio.listarPorId(idProveedor);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            return "FormularioProveedor";
        } else {
            return "redirect:/listarProveedor";
        }
    }

    @PostMapping("/Proveedor/editar")
    public String actualizarProveedor(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proveedor", proveedor);
            return "FormularioProveedor";
        }
        try {
            servicio.guardarProveedor(proveedor);
        } catch (Exception e) {
            logger.error("Error al actualizar el proveedor.", e);
            model.addAttribute("errorMensaje", "Error al actualizar el proveedor. Intente nuevamente más tarde.");
            return "FormularioProveedor";
        }
        return "redirect:/listarProveedor";
    }

    @GetMapping("/Proveedor/eliminar/{idProveedor}")
    public String eliminarProveedor(@PathVariable Long idProveedor) {
        try {
            servicio.eliminar(idProveedor);
        } catch (Exception e) {
            logger.error("Error al eliminar el proveedor.", e);
        }
        return "redirect:/listarProveedor";
    }
}