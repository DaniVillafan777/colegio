
package com.emergentes.modelo;


public class Alumno {
    private int id_alum;
    private String nombre;
    private String apellido;
    private int ci;
    private int rude;
    private int curso;
    private String grado;

    public Alumno() {
        this.id_alum=0;
        this.nombre="";
        this.apellido="";
        this.ci=0;
        this.rude=0;
        this.curso=0;
        this.grado="";
    }

    public int getId_alum() {
        return id_alum;
    }

    public void setId_alum(int id_alum) {
        this.id_alum = id_alum;
    }

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

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getRude() {
        return rude;
    }

    public void setRude(int rude) {
        this.rude = rude;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
}
