package com.upiiz.practica.repositories;

import com.upiiz.practica.models.Usuario;
import java.util.List;

public interface UsuariosRepository
{
    //Regrese todos los usuarios
    public List<Usuario> findAll();
    //Regrese un usuario por id
    public Usuario getUsuario(int id);
    //agregar un usuario
    public void save(Usuario usuario);
    //eliminar  un usuario
    public void delete(int id);
    //actualizar un usuario
    public void update(Usuario usuario);

    //metodo para buscar
    Usuario getUsuarioPorCorreo(String correo);

}
