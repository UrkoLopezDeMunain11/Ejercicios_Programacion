package Modelo;

public class Persona {
    private String nombre;
    private String fechaNacimineto;
    private String paisNacimiento;


    public Persona(String nombre, String fechaNacimineto, String paisNacimiento) {
        this.nombre = nombre;
        this.fechaNacimineto = fechaNacimineto;
        this.paisNacimiento = paisNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(String fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimineto='" + fechaNacimineto + '\'' +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                '}';
    }
}
