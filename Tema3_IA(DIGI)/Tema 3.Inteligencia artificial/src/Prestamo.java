import java.time.LocalDate;

public class Prestamo {
    // relaciona un socio con un libro con fechas
        private Socio socio;
        private Libro libro;
        private LocalDate fechaPrestamo;
        private LocalDate fechaDevolucion;

    // Constructor: recibe socio y libro, establece fechaPrestamo a hoy (LocalDate.now())
    public Prestamo(Socio socio, Libro libro) {
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now(); // fecha de hoy
        this.fechaDevolucion = null; // inicialmente no hay fecha de devolución
    }

    // M´etodo estaDevuelto(): devuelve true si fechaDevolucion no es null
    public boolean estaDevuelto() {
        return fechaDevolucion != null;
    }

    // M´etodo devolver(): establece fechaDevolucion a hoy solo si no estaba ya devuelto
    public void devolver() {
        if (!estaDevuelto()) {
            this.fechaDevolucion = LocalDate.now(); // fecha de hoy
        }
    }

    // toString() descriptivo con todas las fechas
    @Override
    public String toString() {
        return "Prestamo{" +
                "socio=" + socio.getNombre() +
                ", libro=" + libro.getTitulo() +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + (fechaDevolucion != null ? fechaDevolucion : "No devuelto") +
                '}';
    }





}
