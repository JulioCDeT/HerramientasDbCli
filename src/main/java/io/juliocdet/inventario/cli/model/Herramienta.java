package io.juliocdet.inventario.cli.model;

import java.util.Objects;

public class Herramienta implements Comparable<Herramienta>{
    private int id;
    private String nombre;
    private int cantidad;
    private String categoria;

    public Herramienta(int id, String nombre, int cantidad, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public Herramienta(String nombre, int cantidad, String categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public Herramienta(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Herramienta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herramienta that = (Herramienta) o;
        return id == that.id &&
                cantidad == that.cantidad &&
                nombre.equals(that.nombre) &&
                categoria.equals(that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, cantidad, categoria);
    }

    @Override
    public int compareTo(Herramienta o) {
        return this.id - o.id;
    }
}
