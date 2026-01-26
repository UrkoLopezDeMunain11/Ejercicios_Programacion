import Modelo.Cliente;
import Modelo.Mascota;
import Modelo.Veterinario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Mascota> mascotas = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Veterinario> veterinarios = new ArrayList<>();

    public static void main(String[] args) {

        try {
            generarDatos();

            mostrarMenu();
        }catch (NullPointerException e){
            System.out.println("el programa termina");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }



    private static void generarDatos() {


        Cliente cl1 = null;
        Veterinario vt1 = null;
        Mascota mc1 = new Mascota("hiru", "12/03/2024", "M", "balnco", "Pastor belga", 45, 6, cl1, vt1);
        mascotas.add(mc1);
        Cliente cl2 = null;
        Veterinario vt2 = null;
        Mascota mc2 = new Mascota("Luna", "08/11/2023", "H", "negro", "Bouldog", 56, 3, cl2, vt2);
        mascotas.add(mc2);
        //aqui creo las mascotas y se las paso a los clientes y veterinarios creados antes lo que estos con su new ArrayList<>()   guardaran su mascota en su lista privada de cada uno


        cl1 = new Cliente("Ander", "Arriaga", "456745490", new ArrayList<>());
        clientes.add(cl1);
        cl2 = new Cliente("Julen", "Salburua", "234546578", new ArrayList<>());
        clientes.add(cl2);
        //si hubiese puesto mascotas a todos los cliented les saldria las mismas mascotas, porq saldira la lista de todas las mascotas q hemos guardado en esta list
        //new ArrayList<>() con esto en cambio a cads uno le saldria la suya, no saldria la lista de todas las mascotas a todos
        //new ArrayList<>() crea una lista vacía nueva, independiente para cada cliente. Lo que hara q cada cliente le lleve a listas diferentes, no la la global

        System.out.println("Estas son las mascotas que tendira el cliente" + cl1.getNombre());
        for (Mascota mascota : cl1.getMascotas()) {
            System.out.println("Nombre: " + mascota.getNombre());
        }


        vt1 = new Veterinario("Andoni", "Aranbizkarra", "324554332", "34546543W", "2345", new ArrayList<>());
        veterinarios.add(vt1);
        vt2 = new Veterinario("Eneko", "Lakua", "342433454", "54432345L", "2334", new ArrayList<>());
        veterinarios.add(vt2);
        //igual que lo que he puesto arriba




    }


    private static void mostrarMenu() {
        
        boolean opcionValida = false;
        do {
            try {
                System.out.println("-----------------------------------------MENU-----------------------------------------");
                System.out.println("1. Mostrar el numero de clientes que poseen un tipo de animal concreto");
                System.out.println("2. Datos personales del cliente a partir del nombre de mascota. Suponemos que es unico");
                System.out.println("3. Datos del veterinario a partir de los datos de una mascota");
                System.out.println("4. Datos de las mascotas de un cliente");
                System.out.println("5. Datos de las mascotas de un veterinario");
                System.out.println("6. Terminar");
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("**INTRODUCE UNA OPCION**");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        mostrarNumeroClientesPoseenUnAnimal();
                        break;
                    case 2:
                        datosClientePartiendoDelNombreAnimal();
                        break;
                    case 3:
                        datosVeterinarioPartiendoDatosMascota();
                        break;
                    case 4:
                        datosMascotaDeCliente();
                        break;
                    case 5:
                        datosMascotaDeveterinario();
                        break;
                    case 6:
                        System.out.println("¡¡SALIENDO DEL PROGRAMA!!");
                        opcionValida = true;
                        break;
                    default:
                        System.out.println("OPCION INTRODUCIDA INCORRECTA, VUELVE A INTENTARLO");
                        opcionValida = false;

                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR!!!!");
                sc.next();
                opcionValida = false;
            }
        }while(!opcionValida);


    }

    private static void mostrarNumeroClientesPoseenUnAnimal() {
        System.out.println("Clientes que poseen al menos una mascota: ");


        if (clientes.isEmpty()) {//si esta vacio pues entrara aqui
            System.out.println("No hay ningún cliente registrado.");
        } else {
            int contador = 1; // Para numerar solo los clientes que tienen mascotas
            for (int i = 0; i < clientes.size(); i++) {
                if (!clientes.get(i).getMascotas().isEmpty()) {
                    System.out.println(contador + ". " + clientes.get(i).getNombre() +  clientes.get(i).getMascotas());
                    contador++; // aumenta solo si el cliente tiene mascota
                }
            }
            if (contador == 1) {
                System.out.println("Ningún cliente tiene mascotas.");
            }
        }

    }

    private static void datosClientePartiendoDelNombreAnimal() {
        boolean nombreMascotaValido = false;
        do {
            System.out.println("Introduce el nombre de la mascota");
            String nombreAnimal = sc.next();
            nombreMascotaValido = false;//para reiniciarlo a false, porq cada vez q vuelva si antes al recorrer tosddo ha salido con true aqui entrara con true, se ha quedado ese, entonces lo reiniciamos a false para q vuelva a funcionar bien si meto otro nombre de mascota
            for (Mascota mascota : mascotas) {
                if (mascota.getNombre().equalsIgnoreCase(nombreAnimal)) {
                    Cliente cliente = mascota.getCliente(); //para obtener el cliente dueño de esa mascota, porque en mascota tenemos la relacion Cliente cliente
                    System.out.println("Datos del cliente:");
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("Apellido: " + cliente.getDireccion());
                    System.out.println("DNI: " + cliente.getTelefono());
                    nombreMascotaValido = true;
                }

                if(!nombreMascotaValido){
                    System.out.println("El nombre de la mascota introducida no existe, inténtelo de nuevo");
                }
            }
        }while(!nombreMascotaValido);


    }

    private static void datosVeterinarioPartiendoDatosMascota() {
        boolean nombreMascotaValido1 = false;
        do {
            System.out.println("Introduce el nombre de la mascota");
            String nombreAnimal = sc.next();
            nombreMascotaValido1 = false;
            for (Mascota mascota : mascotas) {
                if (mascota.getNombre().equalsIgnoreCase(nombreAnimal)) {
                    mascota.getCliente();
                }
            }
        }while(!nombreMascotaValido1);


    }

    private static void datosMascotaDeCliente() {

        System.out.println("Introduce el nombnre del cliente");
        String nombreCliente = sc.next();
        boolean clienteEncontrado = false;
        for(Cliente cliente : clientes) {
            if(cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                clienteEncontrado = true;


                //ahora vamos ha mostrar las mascotas del cliente
                if (cliente.getMascotas().isEmpty()) {//si el clinete notiene mascotas pues entraria qui
                    System.out.println("El cliente no tiene mascotas.");
                }else {//si tieen entraria aqui
                    for(Mascota mascota : cliente.getMascotas()) {
                        System.out.println("Nombre: " + mascota.getNombre());
                        System.out.println("Fecha de nacimineto: " +  mascota.getFechaNacimiento());
                        System.out.println("Sexo: " + mascota.getSexo());
                        System.out.println("Color" + mascota.getColor());
                        System.out.println("Raza: " + mascota.getRaza());
                        System.out.println("Peso: " + mascota.getPeso());
                        System.out.println("Longitud: " + mascota.getLongitud());
                    }
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado.");
        }

    }

    private static void datosMascotaDeveterinario() {
        System.out.println("Introduce el nombre del veterinario: ");
        String nombreAnimal = sc.next();
        boolean veterinarioEncontrado = false;
        for(Veterinario veterinario : veterinarios) {
            if (veterinario.getNombre().equalsIgnoreCase(nombreAnimal)) {
                if (veterinario.getMascotas().isEmpty()) {
                    veterinarioEncontrado = true;
                    System.out.println("El veterinario no tiene mascotas");
                }else  {
                    for(Mascota mascota : mascotas) {
                        System.out.println("Nombre: " + mascota.getNombre());
                        System.out.println("Fecha de nacimineto: " +  mascota.getFechaNacimiento());
                        System.out.println("Sexo: " + mascota.getSexo());
                        System.out.println("Color" + mascota.getColor());
                        System.out.println("Raza: " + mascota.getRaza());
                        System.out.println("Peso: " + mascota.getPeso());
                        System.out.println("Longitud: " + mascota.getLongitud());
                    }
                }
            }
        }
    }
}