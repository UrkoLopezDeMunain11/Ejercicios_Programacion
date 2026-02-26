public class LibroDigital extends Libro {

    private String formato;
    private double tamanoMB;

    public LibroDigital(String titulo, String autor, String ISBN, String formato, double tamanoMB) {
        super(titulo, autor, ISBN); // llamamos al constructor de la clase padre (Libro)
        this.formato = formato;
        this.tamanoMB = tamanoMB;
    }

    @Override
    public String toString() {
        return super.toString() + // llamamos al toString() de la clase padre (Libro)
                ", formato='" + formato + '\'' +
                ", tamanoMB=" + tamanoMB +
                '}';
    }


}
