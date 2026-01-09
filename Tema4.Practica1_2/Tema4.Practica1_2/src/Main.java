import Modelo.Alumno;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Alumno> agenda = new ArrayList<>();
        String respuesta;
        do {
            boolean codigoValido = false;
            int codigo;
            do {
                codigo = 0;
                try {
                    System.out.println("Ingresa el codigo del alumno");
                    codigo = sc.nextInt();
                    codigoValido = true;
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("ERROR");
                    codigoValido = false;
                    sc.nextLine();
                }
            } while (!codigoValido);

            System.out.println("Ingresa el nombre del alumno");
            String nombre = sc.nextLine();

            System.out.println("Ingresa el domicilio del alumno");
            String domicilio = sc.nextLine();

            System.out.println("Ingresa el telefono del alumno");
            String telefono = sc.nextLine();

            Alumno alumno = new Alumno(codigo, nombre, domicilio, telefono);//creo el alumno
            agenda.add(alumno);//cuando esta creado, lo meto en la agenda, lo añado, lo guardo ahi en mi arraylist


            System.out.println("Desea añadir añgun añumno mas? (SI/NO)");
            respuesta = sc.nextLine();


        } while (respuesta.equalsIgnoreCase("SI"));

        String opcion;
        do {
            boolean encontrado;
            do {
                System.out.println("Ingrese el codigo del alumno que desea buscar: ");
                int codigoAlumno = sc.nextInt();
                sc.nextLine();

                encontrado = false;
                for (Alumno alumno : agenda) {
                    if (alumno.getCodigo() == codigoAlumno) {//si el alumno tiene código 2, el q hemos metido arriaba cuando pregunte codigo y el usuario mete codigo 2 cuando nos preguntan el alumno que quiere buscar 2, el if será verdadero y se ejecutará porque ese 2 si que exuiste
                        System.out.println("Datos del alumno: ");
                        System.out.println("Nombre: " + alumno.getNombre());//con el get veo lo cque tiene en el nombre
                        System.out.println("Domicilio: " + alumno.getDomicilio());
                        System.out.println("Telefono: " + alumno.getTelefono());
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Alumno no enocntrado, vuelve a intentralo");
                    encontrado = false;
                }

            } while (!encontrado);

            System.out.println("desea buscar otro alumno: (SI/NO)");
            opcion = sc.nextLine();

        } while (opcion.equalsIgnoreCase("SI"));
    }
}