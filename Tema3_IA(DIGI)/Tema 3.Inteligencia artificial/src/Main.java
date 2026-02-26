//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear una biblioteca con al menos 3 libros (1 digital) y 2 socios.
            Biblioteca biblioteca = new Biblioteca();
            Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
            Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
            Libro libro3 = new LibroDigital("1984", "George Orwell", 1949, "PDF");
            Socio socio1 = new Socio("Juan Pérez", "12345678A");
            Socio socio2 = new Socio("María Gómez", "87654321B");

            biblioteca.agregarLibro(libro1);
            biblioteca.agregarLibro(libro2);
            biblioteca.agregarLibro(libro3);
            biblioteca.agregarSocio(socio1);
            biblioteca.agregarSocio(socio2);

        // quiero que Realizar 2 pr´estamos distintos
            biblioteca.realizarPrestamo("12345678A", libro1.getISBN());
            biblioteca.realizarPrestamo("87654321B", libro3.getISBN());

         // quiero Intentar prestar un libro ya prestado (gestionar el error)
            biblioteca.realizarPrestamo("12345678A", libro1.getISBN());

         // quiero Devolver un libro y volver a prestarlo
            biblioteca.devolverLibro(libro1.getISBN());
            biblioteca.realizarPrestamo("12345678A", libro1.getISBN());

         // quiero Mostrar el cat´ alogo y la lista de socios al final
            System.out.println("Catálogo de libros:");
            biblioteca.mostrarCatalogo();
            System.out.println("\nLista de socios:");
            biblioteca.mostrarSocios();

    }
}