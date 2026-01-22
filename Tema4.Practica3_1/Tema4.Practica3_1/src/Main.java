import Modelo.Alumno;
import Modelo.Autor;
import Modelo.Libro;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static List<Libro> libros = new ArrayList<Libro>();
    private static List<Alumno> alumnos = new ArrayList<Alumno>();

    public static void main(String[] args) {
        try {

            generearDatos();

            mostrarMenu();

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


    private static void generearDatos() {

        //Crear autores
        Autor a1 = new Autor("Miguel de Cervantes","20/01/1990","España");
        Autor a2 = new Autor("Gabriel García Márquez", "04/11/2000","Francia");

        //Crear libros
        Libro l1 = new Libro("Don Quijote de la Mancha","Pearson", 100,3,a1);
        libros.add(l1);//lo guardo en mi lista de libros
        Libro l2 = new Libro("Cien Años de Soledad", "Elsevier", 120, 3,a2);
        libros.add(l2);//lo guardo en mi lista de libros

        //Crear alumnos
        Alumno al1 = new Alumno("Ander","20/05/2004","España","43672198E",libros);
        alumnos.add(al1);//lo guardo en mi lista de laumnos
        Alumno al2 = new Alumno("Igor", "10/08/2006", "Portugal","89786756A", libros);
        alumnos.add(al2);//lo guardo en mi lista de laumnos
    }

    private static void mostrarMenu() {
        boolean opcionVailda = false;
        do {
            try {
                System.out.println("----------------MENU BIBLIOTECA--------------");
                System.out.println("1. Alquilar Libro");
                System.out.println("2. Devolver Autor");
                System.out.println("3. Ver Datos Disponibles");
                System.out.println("0. Salir");
                System.out.println("---------------------------------------------");
                System.out.println("ELIGE UNA OPCION: ");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        alquilarLibro();
                        break;
                    case 2:
                        devolverLibro();
                        break;
                    case 3:
                        verDatosDisponibles();
                        break;
                    case 0:
                        System.out.println("SALIENDO DEL PROGRAMA!!!!");
                        opcionVailda = true;
                        break;
                    default:
                        System.out.println("OPCION INTRODUCIDA INCORRECTA, VUELVELO A INTENTAR");
                        opcionVailda = false;

                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR!!!!");
                sc.next();
                opcionVailda = false;
            }
        }while(!opcionVailda);


    }

    private static void alquilarLibro() {

        //SOLICITAR ALUMNO
        System.out.println("Alumnos disponibles:");//te enseño la lista de los alumnos que hay
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }

        boolean alumnoDevuleveValido = false;
        int alumnoDevuelve;
        do {
            System.out.print("Selecciona el alumno que devuelve un libro: ");
            alumnoDevuelve = sc.nextInt();

            if (alumnoDevuelve < 0 || alumnoDevuelve > alumnos.size()) {//para si mete un alumno fuera de rango, entre aqui y diga q no esxiste, si hay dos alumnos y mete arriba cuando le ppregutan el alumno, 3 pues entrara aqui y dira q no existe
                System.out.println("Alumno seleccionado no existe");
                sc.next();
                alumnoDevuleveValido = false;
            } else {
                alumnoDevuleveValido = true;
            }
        } while (!alumnoDevuleveValido);

        System.out.println("Eres el alumno" + alumnoDevuelve + "Introduce el libro o los libros que quieres alquilar: ");

        //SOLICITAR LIBRO
        System.out.println("Libros disponibles: ");
        for (int i = 0; i < libros.size(); i++) {//para ver los libros disponibles que hay
            System.out.println(i + 1 + ", " + libros.get(i).getTitulo());
        }

        boolean libroEncontrado = false;
        do {
            boolean libroValido = false;
            String titulo;
            do {
                System.out.println("Introduzca el titulo del libro que quires alquilar: ");
                titulo = sc.next();
                Pattern p1 = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚ]+$");
                Matcher m1 = p1.matcher(titulo);
                if (m1.matches()) {
                    libroValido = true;
                } else {
                    System.out.println("Nombre introducido invalido");
                    libroValido = false;
                }
            } while (!libroValido);

            for (int i = 0; i < libros.size(); i++) {//si ehe introducido arriba don quijkote, se mete aqui en el bucle mirando todos los libros hasta que de si es que existe con el mismo  nombre. si no da es q no esta. y luego cuando vuelva a introducir otro nuemro entra e enste bucle y hara lo mismo, comparara si es igual q el primer libro de la lista sino pues con el segundo...
                Libro libro =  libros.get(i);

                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("¿Cuántos ejemplares quieres alquilar? (1 o 2)");
                    int cantidad = sc.nextInt();


                    if (libro.alquilar(cantidad)) {
                        System.out.println("Alquiler realizado con éxito.");
                    }

                    libroEncontrado = true;
                }

                if(!libroEncontrado){
                    System.out.println("Libro introducido no esta en la biblioteca");
                    libroEncontrado = false;
                }
            }
        }while(!libroEncontrado);




    }

    private static void devolverLibro() {



        System.out.println("Libros en la biblioteca:");//miro los libros que hay, puede ser que ya te hayas llevado los ejemplares pero el libro seguira apareciendo en la lista auqn esta vez con 0 ejemplares
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i+1) + ". " + libros.get(i).getTitulo());
        }

        System.out.println("Alumnos: ");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println((i+1) + ". " + alumnos.get(i).getNombre() );
        }

        System.out.println("Seleccione que alumno eres: ");
        int opc = sc.nextInt();
        Alumno alumno = alumnos.get(opc - 1);


        boolean libroEncontrado = false;
        do {
            System.out.print("Introduce el título del libro que quieres devolver: ");
            sc.nextLine();
            String titulo = sc.next();

            Libro libroADevolver = null;
            for (int i = 0; i < libros.size(); i++) {
                Libro libro =  libros.get(i);
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.print("¿Cuántos ejemplares quieres devolver? (1 o 2): ");
                    int cantidad = sc.nextInt();
                    libro.devolver(cantidad);
                    libroADevolver = libro;
                    libroEncontrado = true;

                }
            }

            if (!libroEncontrado) {
                System.out.println("Libro no encontrado. Inténtalo de nuevo.");
            }


            if (libroADevolver != null) {

                System.out.print("¿Cuántos ejemplares quieres devolver? (1 o 2): ");
                int cantidad = sc.nextInt();


                if (alumno.devolverLibro(libroADevolver, cantidad)) {
                    libroEncontrado = true;
                } else {
                    libroEncontrado = false;
                }
            } else {
                System.out.println("Libro no encontrado en la biblioteca. Inténtalo de nuevo.");
                libroEncontrado = false;
            }

        } while (!libroEncontrado);
    }

    private static void verDatosDisponibles() {
        for (int i = 0; i < libros.size(); i++) {
            Libro libro =  libros.get(i);
            System.out.println((i+1) + ". " + libro.getTitulo());
        }
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno =  alumnos.get(i);
            System.out.println((i+1) + ". " + alumno.getNombre());
        }

    }
}

