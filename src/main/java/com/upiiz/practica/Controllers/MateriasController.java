package com.upiiz.practica.Controllers;

import com.upiiz.practica.models.Materia;
import com.upiiz.practica.models.Usuario;
import com.upiiz.practica.services.MateriasService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/materias")
public class MateriasController {

    private MateriasService materiasService = new MateriasService();

    // Listar materias
    @GetMapping
    public String listarMaterias(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) return "redirect:/login";

        List<Materia> materias = materiasService.getMateriasByUsuario(usuario);
        model.addAttribute("materias", materias);
        return "materias"; // Thymeleaf template materias.html
    }

    // Formulario agregar
    @GetMapping("/agregar")
    public String agregarFormulario(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) return "redirect:/login";

        model.addAttribute("materia", new Materia());
        return "materiaAgregar"; // Thymeleaf template materiaAgregar.html
    }

    // Guardar nueva materia
    @PostMapping("/agregar")
    public String agregarMateria(@ModelAttribute Materia materia, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) return "redirect:/login";

        materiasService.agregarMateria(usuario, materia);
        return "redirect:/materias";
    }

    // Formulario actualizar
    @GetMapping("/actualizar/{id}")
    public String actualizarFormulario(@PathVariable int id, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) return "redirect:/login";

        Materia materia = materiasService.getMateriaById(usuario, id);
        if (materia == null) return "redirect:/materias";

        model.addAttribute("materia", materia);
        return "materiaActualizar"; // Thymeleaf template materiaActualizar.html
    }

    // Actualizar materia
    @PostMapping("/actualizar")
    public String actualizarMateria(@ModelAttribute Materia materia, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) return "redirect:/login";

        materiasService.actualizarMateria(usuario, materia);
        return "redirect:/materias";
    }

    // Eliminar materia
    @GetMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable int id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) return "redirect:/login";

        materiasService.eliminarMateria(usuario, id);
        return "redirect:/materias";
    }
}
