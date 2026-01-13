import Modelo.Estudio;
import Modelo.Pelicula;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int duracionMinutos;
    private static Pelicula pelicula;

    public static void main(String[] args) {
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        ArrayList<Estudio> estudios = new ArrayList<Estudio>();

        //PELICULAS
        String respuesta;
        do {
            System.out.println("-------------------------PELICULA--------------------------");

            boolean tituloValido = false;
            String titulo;
            do {
                System.out.println("INTRODUCE EL TITULO DE LA PELICULA: ");
                titulo = sc.nextLine();
                Pattern t1 = Pattern.compile("^[A-Za-z]+$");
                Matcher m1 = t1.matcher(titulo);
                if (m1.matches()) {
                    tituloValido = true;
                } else {
                    System.out.println("titulo intoducido incorrecto!!");
                    tituloValido = false;
                }
            } while (!tituloValido);


            boolean añoValido = false;
            int año = 0;
            do {
                try {
                    System.out.println("INTRODUCE EL AÑO DE LA PELICULA: ");
                    año = sc.nextInt();
                    añoValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERROR!!");
                    sc.next();
                    añoValido = false;
                }
            } while (!añoValido);


            boolean duracionValido = false;
            duracionMinutos = 0;
            do {
                try {
                    System.out.println("INTRODUCE LA DURACION DE LA PELICULA EN MINUTOS: ");
                    duracionMinutos = sc.nextInt();
                    duracionValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERROR!!");
                    sc.next();
                    duracionValido = false;
                }
            } while (!duracionValido);


            boolean tipoValido = false;
            String tipo;
            do {
                System.out.println("INTRODUCE EL TIPO DE PELICULA: ");
                tipo = sc.next();
                Pattern ti1 = Pattern.compile("^[A-Za-z]+$");
                Matcher m1 = ti1.matcher(tipo);
                if (m1.matches()) {
                    tipoValido = true;
                } else {
                    System.out.println("tipo intoducido incorrecto!!");
                    tipoValido = false;
                }
            } while (!tipoValido);

            pelicula = new Pelicula(titulo, año, duracionMinutos, tipo, estudios);
            peliculas.add(pelicula);

            boolean resuestaValida = false;
            do {
                System.out.println("Desea añadir alguna persona mas? (SI/NO)");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Respeusta ingresada invalida, vuelve a intentarlo");
                    resuestaValida = false;
                } else {
                    resuestaValida = true;
                }

            } while (!resuestaValida);


        } while (respuesta.equalsIgnoreCase("SI"));



        //ESTUDIOS
        Estudio estudio1 = new Estudio("Universal", "Madrid", "Arriaga", "universal.com", "1990","España", "123456789");
        estudios.add(estudio1);

        Estudio estudio2 = new Estudio("Warner", "Barcelona", "Salburua", "warner.com", "2000","Alemania","987654321");
        estudios.add(estudio2);

        Estudio estudio3 = new Estudio("Walt", "Sevilla", "Arantzabela", "walt.com", "2001","Francia","98204121");
        estudios.add(estudio2);

        Estudio estudio4 = new Estudio("Century", "Almeria", "Aranbizkarra", "century.com", "1994","Belgica","980051121");
        estudios.add(estudio2);

        Estudio estudio5 = new Estudio("Paramount", "Malaga", "Arana", "paramount.com", "2008","Portugal","123654301");
        estudios.add(estudio2);

        //LOS ESTUDIOS QUE HAY, MOSTRADOS EN LISTA
        System.out.println("Selecciona los estudios que han producido esta pelicula");
        for (int i = 0; i < estudios.size(); i++) {
            System.out.println((i + 1) + ". " + estudios.get(i).getNombre());
        }

        sc.nextLine();
        String estudiosSeleccionados = sc.nextLine();
        String[] indices = estudiosSeleccionados.split(",");
        for (String indi : indices) {
            int i = Integer.parseInt(indi.trim()) - 1;
            if (i >= 0 && i < estudios.size()) {
                pelicula.getListaEstudios().add(estudios.get(i));
            }
        }

        //para mostrar la pelicula mas larga
        Pelicula peliculaMasLarga = null;
        int maxDuracion = 0;
        for (Pelicula p : peliculas) {
            if (p.getDuracionMinutos() > maxDuracion) {
                maxDuracion = p.getDuracionMinutos();
                peliculaMasLarga = p;
            }
        }

        System.out.println("LA PELICULA MAS LARGA ES: " + peliculaMasLarga.getTitulo());
        System.out.println("LOS ESTUDIOS QUE LA PRODUJERSN: ");
        for (Estudio estudio : peliculaMasLarga.getListaEstudios()) {
            System.out.println(estudio.getNombre());
        }


        Estudio estudioMax = null;
        int maxPeliculas = 0;

        for (Estudio e : estudios) {
            int contador = 0;
            for (Pelicula p : peliculas) {
                if (p.getListaEstudios().contains(e)) {
                    contador++;
                }
            }
            if (contador > maxPeliculas) {
                maxPeliculas = contador;
                estudioMax = e;
            }
        }

        System.out.println("El estudio que más películas ha producido es: " + estudioMax.getNombre());
    }
}
