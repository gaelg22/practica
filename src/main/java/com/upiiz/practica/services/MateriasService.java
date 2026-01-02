package com.upiiz.practica.services;

import com.upiiz.practica.models.Materia;
import com.upiiz.practica.models.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MateriasService {

    // Map que guarda la lista de materias por cada usuario (por id de usuario)
    private Map<Integer, List<Materia>> materiasPorUsuario = new HashMap<>();
    private int lastId = 0;

    // Obtener materias de un usuario
    public List<Materia> getMateriasByUsuario(Usuario usuario) {
        return materiasPorUsuario.getOrDefault(usuario.getId(), new ArrayList<>());
    }

    // Agregar materia para un usuario
    public void agregarMateria(Usuario usuario, Materia materia) {
        lastId++;
        materia.setId(lastId);

        materiasPorUsuario.putIfAbsent(usuario.getId(), new ArrayList<>());
        materiasPorUsuario.get(usuario.getId()).add(materia);
    }

    // Actualizar materia de un usuario
    public void actualizarMateria(Usuario usuario, Materia materia) {
        List<Materia> lista = materiasPorUsuario.get(usuario.getId());
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == materia.getId()) {
                    lista.set(i, materia);
                    break;
                }
            }
        }
    }

    // Eliminar materia de un usuario
    public void eliminarMateria(Usuario usuario, int materiaId) {
        List<Materia> lista = materiasPorUsuario.get(usuario.getId());
        if (lista != null) {
            lista.removeIf(m -> m.getId() == materiaId);
        }
    }

    // Obtener materia por ID para un usuario
    public Materia getMateriaById(Usuario usuario, int id) {
        List<Materia> lista = materiasPorUsuario.get(usuario.getId());
        if (lista != null) {
            return lista.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
        }
        return null;
    }
}
