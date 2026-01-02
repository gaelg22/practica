package com.upiiz.practica.repositories;

import com.upiiz.practica.models.Materia;
import com.upiiz.practica.models.Usuario;

import java.util.List;

public interface MateriasRepository {

    List<Materia> findAll(Usuario usuario); // Listar materias de un usuario

    Materia getMateria(Usuario usuario, int id); // Obtener materia específica de un usuario

    void save(Usuario usuario, Materia materia); // Guardar materia para un usuario

    void update(Usuario usuario, Materia materia); // Actualizar materia de un usuario

    void delete(Usuario usuario, int id); // Eliminar materia de un usuario
}
