package com.upiiz.practica.Controllers;

import com.upiiz.practica.models.Usuario;
import com.upiiz.practica.services.UsuariosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuariosController {

    private UsuariosService usuarioService = new UsuariosService();

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String registroFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";  // registro.html
    }

    // Guardar usuario
    @PostMapping("/registro")
    public String registro(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/login";
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String loginFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";  // login.html
    }

    // Procesar login
    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        Usuario encontrado = usuarioService.getUsuarioPorCorreo(usuario.getCorreo());
        if (encontrado != null && encontrado.getContrasena().equals(usuario.getContrasena())) {
            session.setAttribute("usuarioLogueado", encontrado); // Guardar usuario en sesión
            return "redirect:/usuarios";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrecta");
            return "login";
        }
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // Listado de usuarios
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model, HttpSession session) {
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("usuarioActual", session.getAttribute("usuarioLogueado"));
        return "usuarios"; // usuarios.html
    }
}