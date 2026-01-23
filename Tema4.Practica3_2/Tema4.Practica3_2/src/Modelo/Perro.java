package Modelo;

public class Perro extends Mascota {
    public Perro(String nombre, String fechaNacimiento, String sexo, String color, String raza, float peso, float longitud, Cliente cliente, Veterinario veterinario) {
        super(nombre, fechaNacimiento, sexo, color, raza, peso, longitud, cliente, veterinario);
    }
}
