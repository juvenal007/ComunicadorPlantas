package com.example.juvenalsalas.comunicadorplantas.basededatos;

public class Planta {

    public int id;
    public String titulo;
    public String nombreComun;
    public String nombre;
    public String nombreCientifico;
    public String altura;
    public String descripcion;
    public String fecha;
    public double temperatura;
    public double humedad;
    public int foto1;

    public Planta(){

    }

    public Planta(int id, String titulo, String nombreComun, String nombre, String nombreCientifico, String altura, String descripcion, String fecha, double temperatura, double humedad, int foto1) {
        this.id = id;
        this.titulo = titulo;
        this.nombreComun = nombreComun;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.altura = altura;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.foto1 = foto1;
    }

    public Planta(String titulo, String nombreComun, String nombre, String nombreCientifico, String altura, String descripcion, String fecha, double temperatura, double humedad, int foto1) {
        this.titulo = titulo;
        this.nombreComun = nombreComun;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.altura = altura;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.foto1 = foto1;
    }
}
