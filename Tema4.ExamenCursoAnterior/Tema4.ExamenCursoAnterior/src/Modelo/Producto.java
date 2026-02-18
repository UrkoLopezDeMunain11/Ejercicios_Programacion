package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Producto {
    private String nombre;
    private float precio;
    private int stock;


    public Producto(String nombre, float precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    public boolean realizarPedido(int cantidad){
        this.stock = this.stock - cantidad;
        return true;
    }

    @Override
    public String toString() {
        return "\n **PRODUCTO**" +
                "\n - Nombre: " + nombre +
                "\n - Precio: " + precio +
                "\n - Stock: " + stock;
    }
}
