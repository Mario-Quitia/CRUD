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
import com.example.crud.entidades.Cliente;
import com.example.crud.repositorioservicios.IClientesServicios;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ClienteControlador {
    private static final Logger logger = LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    private IClientesServicios servicio;

    @GetMapping("/listarClientes")

    public String mostrarListacllientes(Model model) {

        try {
            List<Cliente> clientes = servicio.listar();
            model.addAttribute("clientes", clientes);
            logger.info("Listado de clientes obtenido con éxito.");
        }

        catch (Exception e) {
            // Logueo del error y adición de un mensaje de error al modelo.
            logger.error("Error al obtener el listado de productos.", e);
            model.addAttribute("errorMensaje", "Error al obtener productos. Intente nuevamente más tarde.");
        }
        // Retorna el nombre de la vista 'index' que debe estar en la carpeta de
        // recursos de vistas.
        return "index";

    }

  @GetMapping("/cliente/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "FormularioCliente"; // Nombre de la vista del formulario para crear producto
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "FormularioCliente";  // Retornar a la vista del formulario si hay errores.
        }
        try {
            servicio.guardar(cliente);
        } catch (Exception e) {
            logger.error("Error al guardar el cliente.", e);
            model.addAttribute("errorMensaje", "Error al guardar el cliente. Intente nuevamente más tarde.");
            return "FormularioCliente";
        }
        return "redirect:/listarClientes";
    }


      @GetMapping("/cliente/editar/{idCliente}")
    public String mostrarFormularioEditar(@PathVariable Long idCliente, Model model) {
        Optional<Cliente> cliente = servicio.listarPorId(idCliente);
        if (cliente.isPresent()) {
            model.addAttribute("producto", cliente.get());
            return "formularioCliente";
        } else {
            return "redirect:/listarClientes";
        }
    }

    @PostMapping("/cliente/editar")
    public String actualizarCliente(@Valid @ModelAttribute("producto") Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "formularioCliente";
        }
        try {
            servicio.guardar(cliente);
        } catch (Exception e) {
            logger.error("Error al actualizar el cliente.", e);
            model.addAttribute("errorMensaje", "Error al actualizar el cliente. Intente nuevamente más tarde.");
            return "formularioCliente";
        }
        return "redirect:/listar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(@PathVariable Long idCliente) {
        try {
            servicio.eliminar(idCliente);
        } catch (Exception e) {
            logger.error("Error al eliminar el Cliente.", e);
        }
        return "redirect:/listarClientes";
    }
}


