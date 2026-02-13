//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner sc;
    static ArrayList<String> nombres;
    static ArrayList<Double> notas;
    static String[] asignaturas;

    public static void main(String[] args) {
        introducirNombres();
        PrintStream var10000 = System.out;
        int var10001 = nombres.size();
        var10000.println("La cantidad de alumnos que tienes guardados son: " + var10001 + " .Con nombres: " + String.valueOf(nombres));
        pedirNotas();
        notaMediaProgramacion();
    }

    private static void introducirNombres() {
        String respuesta;
        do {
            boolean nombreValido = false;

            do {
                System.out.println("Introduce el nombre del alumno: ");
                String nombre = sc.nextLine();
                Pattern pt = Pattern.compile("^[A-Za-z]*$");
                Matcher mat = pt.matcher(nombre);
                if (mat.matches()) {
                    System.out.println("Nombre correcto");
                    nombres.add(nombre);
                    nombreValido = true;
                } else {
                    System.out.println("Nombre incorrecto");
                    nombreValido = false;
                }
            } while(!nombreValido);

            boolean respuestaValida = false;

            do {
                System.out.println("Quieres introducir mas alumnos???(SI/NO)");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Valor introducido incorrecto");
                    respuestaValida = false;
                } else {
                    respuestaValida = true;
                }
            } while(!respuestaValida);
        } while(respuesta.equalsIgnoreCase("SI"));

    }

    private static void pedirNotas() {
        for(int i = 0; i < nombres.size(); ++i) {
            System.out.println("Estas con el alumno: " + (String)nombres.get(i));

            for(int j = 0; j < asignaturas.length; ++j) {
                String var10001 = asignaturas[j];
                System.out.println("Estas matriculado en: " + var10001);
                String matriculado = sc.nextLine();
                if (matriculado.equalsIgnoreCase("Si")) {
                    var10001 = asignaturas[j];
                    System.out.println("Introduce la nota de la asignatura: " + var10001 + " es de: ");
                    double nota = Double.parseDouble(sc.nextLine());
                    notas.add(nota);
                } else {
                    System.out.println("No estas matriculado");
                }
            }
        }

        for(int i = 0; i < nombres.size(); ++i) {
            System.out.println("El alumno: " + (String)nombres.get(i));

            for(int j = 0; j < asignaturas.length; ++j) {
                String var8 = asignaturas[j];
                System.out.println("Con asignatura: " + var8 + "con nota: " + String.valueOf(notas.get(i)));
            }
        }

    }

    private static void notaMediaProgramacion() {
        double sumaTotal = (double)0.0F;
        double mediaProgramacion = (double)0.0F;

        for(int i = 0; i < notas.size(); ++i) {
            sumaTotal += (Double)notas.get(i);
        }

        mediaProgramacion = sumaTotal / (double)notas.size();
        System.out.println("La media de programacion es de: " + mediaProgramacion);
    }

    static {
        sc = new Scanner(System.in);
        nombres = new ArrayList();
        notas = new ArrayList();
        asignaturas = new String[]{"Programacion", "ED", "BD", "IPEI", "Sostenibilidad", "LM", "DIGI", "Ingles"};
    }
}
