import Modelo.Persona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static LocalDate fechanacimiento;

    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();

        String respuesta;
        do {
            boolean nombreValido = false;
            String nombre;
            do {
                System.out.println("ingrese el nombre: ");
                nombre = sc.nextLine();
                Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
                Matcher m1 = p1.matcher(nombre);
                if (m1.matches()) {
                    System.out.println("nombre ingresado correctamente");
                    nombreValido = true;
                } else {
                    System.out.println("nombre incorrecto");
                    nombreValido = false;
                }
            } while (!nombreValido);

            boolean fechaValida = false;
            int n = 0;
            int m = 0;
            int a = 0;
            do {
                try {
                    System.out.println("Ingrese el dia de naciemiento: ");
                    n = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el mes de naciemiento: ");
                    m = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el año de naciemiento: ");
                    a = sc.nextInt();
                    sc.nextLine();

                    fechanacimiento = LocalDate.of(a, m, n);
                    System.out.println("fecha de nacieminto de: " + nombre +" " + "es de: " + fechanacimiento);
                    fechaValida = true;
                } catch (DateTimeException e) {
                    System.out.println("Error en el formato de datos");
                    fechaValida = false;
                }
            } while (!fechaValida);

            boolean direccionValida = false;
            String direccion;
            do {
                System.out.println("Ingrese la direccion: ");
                direccion = sc.next();
                Pattern d1 = Pattern.compile("^[a-zA-Z]+$");
                Matcher m1 = d1.matcher(direccion);
                if (m1.matches()) {
                    System.out.println("direccion ingresado correctamente");
                    direccionValida = true;
                } else {
                    System.out.println("direccion incorrecto");
                    direccionValida = false;
                }
            } while (!direccionValida);

            boolean codigoValido = false;
            String codigoPostal;
            do {
                System.out.println("Ingrese el codigo postal: ");
                codigoPostal = sc.nextLine();
                Pattern c1 = Pattern.compile("^[0-9]{5}$");
                Matcher m1 = c1.matcher(codigoPostal);
                if (m1.matches()) {
                    System.out.println("codigo postal ingresado correctamente");
                    codigoValido = true;
                } else {
                    System.out.println("codigo postal incorrecto");
                    codigoValido = false;
                }
            } while (!codigoValido);

            boolean ciudadvalida = false;
            String ciudad;
            do {
                System.out.println("Ingresde la ciudad: ");
                ciudad = sc.next();
                Pattern ci1 = Pattern.compile("^[a-zA-Z]+$");
                Matcher m1 = ci1.matcher(ciudad);
                if (m1.matches()) {
                    System.out.println("ciudad ingresado correctamente");
                    ciudadvalida = true;
                } else {
                    System.out.println("ciudad incorrecto");
                    ciudadvalida = false;
                }
            } while (!ciudadvalida);

            Persona persona = new Persona(nombre, n, m, a, direccion, codigoPostal, ciudad);
            personas.add(persona);

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


        Persona personaMayor = null;
        for (Persona p : personas) {
            personaMayor = null;
            if (personaMayor == null || p.getFechaNacimiento().isBefore(personaMayor.getFechaNacimiento())) {
                personaMayor = p;
            }
        }
        System.out.println("La persona de mayor edad es: " + personaMayor.getNombre());


        System.out.println("Personas que viven en Elche: ");
        for (Persona pp : personas) {
            if (pp.getCiudad().equalsIgnoreCase("Elche")) {
                System.out.println("*****Nombre: " + pp.getNombre());
            }

        }

        int mayoresEdad = 0;
        for (Persona ppp : personas) {
            int edad = Period.between(ppp.getFechaNacimiento(), LocalDate.now()).getYears();
            if (edad >= 18) {
                mayoresEdad++;
            }
        }

        System.out.println("Número de personas mayores de edad: " + mayoresEdad);

    }
}