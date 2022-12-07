package com.emergentes.modelo;

public class Usuario {

    private int id_u;
    private String nombres;
    private String apellidos;
    private String correo;
    private String pass;

    public Usuario() {
        this.id_u = 0;
        this.nombres = "";
        this.apellidos = "";
        this.correo = "";
        this.pass = "";
    }


    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
