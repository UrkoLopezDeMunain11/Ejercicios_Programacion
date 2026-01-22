package Modelo;

public class Libro {
    private String titulo;
    private String editorial;
    private int numeroDePaginas;
    private int numeroDeEjemplares = 3;
    private Autor autor;//relacion libro autor

    public Libro(String titulo, String editorial, int numeroDePaginas, int numeroDeEjemplares, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.numeroDePaginas = numeroDePaginas;
        this.numeroDeEjemplares = numeroDeEjemplares;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getNumeroDeEjemplares() {
        return numeroDeEjemplares;
    }

    public void setNumeroDeEjemplares(int numeroDeEjemplares) {
        this.numeroDeEjemplares = numeroDeEjemplares;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean alquilar(int cantidad){
        if (cantidad < 1 || cantidad > 2){
            System.out.println("Solo puedes alquilar 1 o 2 ejemplares.");
            return false;
        }
        if (numeroDeEjemplares >= cantidad){  //3 >= 2 entonces entra aqui
            numeroDeEjemplares -= cantidad;
            return true;
        }else {//3 >= 4 no es entoces entraria aqui
            System.out.println("No hay suficientes ejemplares disponibles.");
            return false;
        }
    }

    public boolean devolver(int cantidad){
        if (cantidad < 1 || cantidad > 2){
            System.out.println("Solo puedes devolver 1 o 2 ejemplares.");
            return false;
        }
        //si la cantidad q devuelvo es menor q 1 o mayor q 2 entrara en el if de arriba todoel rato, si es mayo a 1 y menro a 2 no entrara en el if y ira directamente a lo de abajo, a sumar
        numeroDeEjemplares += cantidad;
        System.out.println("Se han devuelto " + cantidad + " ejemplares. Ahora hay " + numeroDeEjemplares);
        return true;

    }



    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", numeroDePaginas=" + numeroDePaginas +
                ", numeroDeEjemplares=" + numeroDeEjemplares +
                ", autor=" + autor +
                '}';
    }
}
