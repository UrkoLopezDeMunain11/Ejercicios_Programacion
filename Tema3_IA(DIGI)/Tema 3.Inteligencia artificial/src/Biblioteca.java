import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> catalogo;

    private ArrayList<Socio> socios;

    public void agregarLibro(Libro libro){
        this.catalogo.add(libro);
    }

    public void agregarSocio(Socio socio){
        this.socios.add(socio);
    }

    public Libro buscarLibroPorISBN(String isbn){
        for (Libro libro : catalogo) {
            if (libro.getISBN().equals(isbn)) {
                return libro; // si encontramos el libro, lo devolvemos
            }
        }
        return null; // si no encontramos el libro, devolvemos null
    }

     public Socio buscarSocioPorDNI(String dni){
        for (Socio socio : socios) {
            if (socio.getDNI().equals(dni)) {
                return socio; // si encontramos el socio, lo devolvemos
            }
        }
        return null; // si no encontramos el socio, devolvemos null
    }

    public void realizarPrestamo(String dni, String isbn){
        Socio socio = buscarSocioPorDNI(dni);
        Libro libro = buscarLibroPorISBN(isbn);

        if (socio != null && libro != null && libro.isDisponible()) {
            Prestamo nuevoPrestamo = new Prestamo(socio, libro);
            socio.agregarPrestamo(libro); // agregamos el préstamo al socio
            libro.setDisponible(false); // marcamos el libro como no disponible
        }
    }

        public void devolverLibro(String isbn) {
            Libro libro = buscarLibroPorISBN(isbn);
            if (libro != null) {
                libro.setDisponible(true); // marcamos el libro como disponible
            }
        }


    public void mostrarCatalogo(){
        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }

    public void mostrarSocios(){
        for (Socio socio : socios) {
            System.out.println(socio);
        }
    }




}
