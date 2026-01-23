package Modelo;

import java.util.List;

public class Veterinario extends Persona {

    private String DNI;
    private String numeroSeguridadSocial;

    private List<Mascota> listaPacientes; //1--N

    public Veterinario(String nombre, String direccion, String telefono, String DNI, String numeroSeguridadSocial, List<Mascota> listaPacientes) {
        super(nombre, direccion, telefono);
        this.DNI = DNI;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.listaPacientes = listaPacientes;
    }


    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public List<Mascota> getMascotas() {
        return listaPacientes;
    }

    public void setMascotas(List<Mascota> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
}
