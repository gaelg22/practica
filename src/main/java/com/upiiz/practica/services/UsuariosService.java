package com.upiiz.practica.services;

import com.upiiz.practica.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuariosService {

    private List<Usuario> usuarios = new ArrayList<>();
    private int lastId = 0;

    public UsuariosService() {
        usuarios.add(new Usuario(1, "gael", "gaelg2927@gmail.com", "chivas22"));
        usuarios.add(new Usuario(2, "pedro", "pedro@gmail.com", "pedro23"));
        lastId = 2;
    }

    public List<Usuario> findAll() { return usuarios; }

    public Usuario getUsuarioPorCorreo(String correo) {
        return usuarios.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .findFirst()
                .orElse(null);
    }

    public void save(Usuario usuario) {
        lastId++;
        usuario.setId(lastId);
        usuarios.add(usuario);
    }

    public boolean validarLogin(String correo, String contrasena) {
        return usuarios.stream()
                .anyMatch(u -> u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena));
    }
}
