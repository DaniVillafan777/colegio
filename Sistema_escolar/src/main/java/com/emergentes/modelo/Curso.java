/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.modelo;


public class Curso {
    private int id_cu;
    private String grado;
    private int num_aula;
    private int id_inmueble;

    public Curso() {
        this.id_cu=0;
        this.grado="";
        this.num_aula=0;
        this.id_inmueble=0;
    }

    public int getId_cu() {
        return id_cu;
    }

    public void setId_cu(int id_cu) {
        this.id_cu = id_cu;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getNum_aula() {
        return num_aula;
    }

    public void setNum_aula(int num_aula) {
        this.num_aula = num_aula;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }
    
}
