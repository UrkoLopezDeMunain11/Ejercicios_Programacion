package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido{
    private LocalDate fecha;
    private Usuario usuario;
    private List<Producto> productos;

    public Pedido(LocalDate fecha, Usuario usuario, List<Producto> productos) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.productos = productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", usuario=" + usuario +
                ", productos=" + productos +
                '}';
    }
}
