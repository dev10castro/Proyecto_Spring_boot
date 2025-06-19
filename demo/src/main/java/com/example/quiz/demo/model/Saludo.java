package com.example.quiz.demo.model;

import jakarta.persistence.*;

@Entity
public class Saludo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;

    public Saludo() {
    }

    public Saludo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //getters y setters

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
