package com.example.myapplication;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private GregorianCalendar fecNac;
    private String curso;

    private boolean repite;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public GregorianCalendar getFecNac() {
        return fecNac;
    }

    public void setFecNac(GregorianCalendar fecNac) {
        this.fecNac = fecNac;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isRepite() {
        return repite;
    }

    public void setRepite(boolean repite) {
        this.repite = repite;
    }
}
