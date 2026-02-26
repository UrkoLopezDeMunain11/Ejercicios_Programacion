import java.util.ArrayList;
import java.util.List;

public class Socio {

    private String nombre;
    private String DNI;
    private List<Prestamo> prestamos;

    public Socio(String nombre, String DNI, List<Prestamo> prestamos) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.prestamos = prestamos;
    }

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.prestamos = new ArrayList<>(); // inicializamos la lista de préstamos vacia
    }

    public void agregarPrestamo(Libro libro){
        Prestamo nuevoPrestamo = new Prestamo(this, libro, "fechaPrestamo", "fechaDevolucion");
        this.prestamos.add(nuevoPrestamo);
    }

    public void eliminarPrestamo(Libro libro){
        this.prestamos.removeIf(prestamo -> prestamo.getLibro().equals(libro));
    }

    public boolean tieneLibrosPrestados() {
        return !prestamos.isEmpty();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", prestamos=" + prestamos +
                '}';
    }

}
