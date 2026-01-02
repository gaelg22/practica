package com.upiiz.practica.models;

public class Materia {
    private int id;
    private String nombre;
    private double creditos;

    public Materia() {}

    public Materia(int id, String nombre, double creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getCreditos() { return creditos; }
    public void setCreditos(double creditos) { this.creditos = creditos; }
}
