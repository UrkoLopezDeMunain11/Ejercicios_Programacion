package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int año;
    private int duracionMinutos;
    private String tipo;

    private List<Estudio> listaEstudios; //relacion Una pelicula es producida en uno o mas estudios

    public Pelicula(String titulo, int año, int duracionMinutos, String tipo, List<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.año = año;
        this.duracionMinutos = duracionMinutos;
        this.tipo = tipo;
        this.listaEstudios = listaEstudios;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(List<Estudio> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }
}
