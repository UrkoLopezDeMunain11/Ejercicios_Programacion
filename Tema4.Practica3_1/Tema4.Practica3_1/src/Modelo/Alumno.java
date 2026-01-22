package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona {
    private String DNI;

    private List<Libro> librosAlquilados;//el alumno tiene una lista de libro, coge libros de la biblioteca.No puede coger mas de dos

    public Alumno(String nombre, String fechaNacimineto, String paisNacimiento, String DNI, List<Libro> librosAlquilados) {
        super(nombre, fechaNacimineto, paisNacimiento);
        this.DNI = DNI;
        this.librosAlquilados = new ArrayList<>();
    }


    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public List<Libro> getLibros() {
        return librosAlquilados;
    }

    public void setLibros(List<Libro> libros) {
        this.librosAlquilados = libros;
    }

    public boolean alquilarlibro(Libro libro, int cantidad){

        if(librosAlquilados.size() > 2 || librosAlquilados.size() < 1) {//para q los libros alquilados no puedan ser mas de 2 o menos de 1, si es asi entra poraqui
            System.out.println("Solo puedes alquilar 1 o dos libros");
            return false;
        }

        if (libro.alquilar(cantidad)) {//si hay 3 ejemplares puede alquilar 2, 3>2 entonces entra en este if . Si hay 1 ejemplar no puede alquilar 2 entonces entra en el else
            if (!librosAlquilados.contains(libro)) {//pasra comprobar  si la lista de libros del alumno ya contiene este libro, asi evitar  q se duplique el libro en la lista o que haya dos iguales
                librosAlquilados.add(libro);// lo añado entonces si no esta
            }
            System.out.println("Libro alquilado correctamente");
            return true;
        }

        return false;
    }

    public boolean devolverLibro(Libro libro, int cantidad){
        if (!librosAlquilados.contains(libro)) {//para saber si tiene libros en la lista de libros alquilados, si nno tiene entra en este if todoel rato, si lo tiene no entra y entra en el siguietne
            System.out.println("No tienes libros alquilados para devolcver");
            return false;
        }
        if(libro.devolver(cantidad)){//llamo al metodo devolver de la clase libro para que sume cantidad a numeroDeEjemplares del libro y devuelva true si se ha echo correctamente
            librosAlquilados.remove(libro);//elimina el libro de la lista de libros alquilados
            System.out.println("Libro delvuelto correctamente");
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "DNI='" + DNI + '\'' +
                ", librosAlquilados=" + librosAlquilados +
                '}';
    }
}
