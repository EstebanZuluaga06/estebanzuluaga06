package com.uco.taller.dispensadora.dominio;

public class Snack {
    private String nombre;
    protected float precio;
    protected int cantidadDisponible;
    protected String codigo;

    public Snack(String nombre, float precio, int cantidadDisponible, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void aumentarCantidad(int cantidad) {
        cantidadDisponible += cantidad;
    }

    public void reducirCantidad(int cantidad) {
        if (cantidadDisponible >= cantidad) {
            cantidadDisponible -= cantidad;
        } else {
            System.out.println("No hay suficientes unidades disponibles.");
        }
    }



}
