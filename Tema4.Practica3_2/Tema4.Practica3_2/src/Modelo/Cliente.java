package Modelo;

import java.util.List;

public class Cliente extends Persona {

    private List<Mascota> mascotas; // 1 cliente tiene 1 o muchas mascotas 1--N


    public Cliente(String nombre, String direccion, String telefono, List<Mascota> mascotas) {
        super(nombre, direccion, telefono);
        this.mascotas = mascotas;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }



}
