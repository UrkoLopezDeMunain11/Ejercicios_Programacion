package Modelo;

import java.util.Date;
import java.util.List;

public class Vuelo{
    private String cod_vuelos;
    private Date fecha_salida;
    private String destino;
    private String procedencia;


    private List<Pasajero> listaPasajeros;

    public Vuelo(String cod_vuelos, Date fecha_salida, String destino, String procedencia, List<Pasajero> listaPasajeros) {
        this.cod_vuelos = cod_vuelos;
        this.fecha_salida = fecha_salida;
        this.destino = destino;
        this.procedencia = procedencia;
        this.listaPasajeros = listaPasajeros;
    }

    public Vuelo() {

    }

// aqui no puede haber ninguno static
    public String getCod_vuelo() {
        return cod_vuelos;
    }

    public void setCod_vuelo(String cod_vuelos) {
        cod_vuelos = cod_vuelos;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        fecha_salida = fecha_salida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        destino = destino;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public  void setProcedencia(String procedencia) {
        procedencia = procedencia;
    }

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public void setListaPasajeros(List<Pasajero> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }


    @Override
    public String toString() {
        return "Vuelo{" +
                "cod_vuelo='" + cod_vuelos + '\'' +
                ", fecha_salida=" + fecha_salida +
                ", destino='" + destino + '\'' +
                ", procedencia='" + procedencia + '\'' +
                ", listaPasajeros=" + listaPasajeros +
                '}';
    }
}
