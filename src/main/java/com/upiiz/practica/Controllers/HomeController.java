package com.upiiz.practica.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session) {

        // Si NO hay sesión → login
        if (session.getAttribute("usuarioActual") == null) {
            return "redirect:/login";
        }

        // Si hay sesión → materias
        return "redirect:/materias";
    }
}