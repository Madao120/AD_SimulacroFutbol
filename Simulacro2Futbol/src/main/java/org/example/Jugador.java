package org.example;

import java.io.Serializable;

public class Jugador implements Serializable {
    transient int id;
    String nombre;
    String posicion;
    int año;
    String descricion;

    public Jugador(int id, String nombre, String posicion, int año, String descricion) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.año = año;
        this.descricion = descricion;
    }

    public Jugador(String nombre, String posicion, int año, String descricion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.año = año;
        this.descricion = descricion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", año=" + año +
                ", descricion='" + descricion + '\'' +
                ", id=" + id +
                '}';
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
}
