package Modelo;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private int dNacimiento;
    private int mNacimiento;
    private int aNacimineto;
    private String direccion;
    private String codigoPostal;
    private String ciudad;

    public Persona(String nombre, int dNacimiento, int mNacimiento, int aNacimineto, String direccion, String codigoPostal, String ciudad) {
        this.nombre = nombre;
        this.dNacimiento = dNacimiento;
        this.mNacimiento = mNacimiento;
        this.aNacimineto = aNacimineto;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getdNacimiento() {
        return dNacimiento;
    }

    public void setdNacimiento(int dNacimiento) {
        this.dNacimiento = dNacimiento;
    }

    public int getmNacimiento() {
        return mNacimiento;
    }

    public void setmNacimiento(int mNacimiento) {
        this.mNacimiento = mNacimiento;
    }

    public int getaNacimineto() {
        return aNacimineto;
    }

    public void setaNacimineto(int aNacimineto) {
        this.aNacimineto = aNacimineto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return LocalDate.of(aNacimineto, mNacimiento, dNacimiento);
    }



}
