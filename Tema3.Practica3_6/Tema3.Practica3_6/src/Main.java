import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] animalesAcepta = {"perro","gato", "conejo", "loro", "tortuga"};//animales q acepata
    static ArrayList<String> animalesRescatados = new ArrayList<>();//para guardar la especie y su nombre Luna- Perro
    static Map<String, String> relacion = new HashMap<>();//para la relacion de los animales con su dueño Clave: Luna Valor: Maía
    static Queue<String> colaAdopcion = new LinkedList<>();//para q el primero que entre sea el primero en salir
    public static void main(String[] args) {

        try {
            menu();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        


    }

    private static void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("------------------MENU-----------------");
                System.out.println("1- Ver especies aceptadas");
                System.out.println("2- Agregar un nuevo animal al listado de rescatados");
                System.out.println("3- Asignar un cuidador a un animal");
                System.out.println("4- Pasar un animal a la cola de espera de adopción");
                System.out.println("5- Adoptar un animal");
                System.out.println("6- Lista todos los animales y sus cuidadores actuales");
                System.out.println("7- SALIR");
                System.out.println("---------------------------------------");
                System.out.println("Ingrese una opcion de estas: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        especiesAceptadas();
                        break;
                    case 2:
                        agregarAnimalListaDeRescatados();
                        break;
                    case 3:
                        asignarCuidadorAnimal();
                        break;
                    case 4:
                        pasarAnimalColaEsperaAdopcio();
                        break;
                    case 5:
                        adoptarAnimal();
                        break;
                    case 6:
                        listaAnimalesCuidadores();
                        break;
                    case 7:
                        System.out.println("SALIENDO DEL PROGRAMA");
                        break;
                    default:
                        System.out.println("Opcion introducida incorrecta, intentelo de nuevo");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR");
                sc.next();
            }
        } while (opcion != 7);
    }

    private static void especiesAceptadas() {
        for (int i = 0; i < animalesAcepta.length; i++) {//recorrer todos los nimales para ver los animales q se acepatn q estan guarados en el array
            System.out.println(i + 1 + " " + animalesAcepta[i]);
        }
    }

    private static void agregarAnimalListaDeRescatados() {
        String respuesta;
        boolean animalValido = false;
        do {

            System.out.println("Ingrese un animaal a la lista de rescatados:");
            String animal = sc.next();
            do {
                if (animal.equalsIgnoreCase("perro") || animal.equalsIgnoreCase("gato") || animal.equalsIgnoreCase("conejo") || animal.equalsIgnoreCase("loro") || animal.equalsIgnoreCase("tortuga")) {
                    System.out.println("Animal agregado correctamente");
                    System.out.println("Ingrese el nombre del animal: ");
                    String nombre = sc.next();
                    String animalCompleto = animal + "-" + nombre;
                    animalesRescatados.add(animalCompleto);
                    animalValido = true;

                } else {
                    System.out.println("El animal introducido no entra en los que acepata el refugio:(perro,gato,conejo,loro,tortuga)");
                    animalValido = false;
                }
            } while (!animalValido);


            System.out.println("Lista de animales rescatados ahora seria de: " + animalesRescatados);

            boolean respuestaValida = false;
            do {
                System.out.println("Desea ingresar algun animal mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("La respuesta introducida es incorrecta, debe de ser SI o NO, intentalo de nuevo");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));
    }

    private static void asignarCuidadorAnimal() {
        String respuesta;
        do {

            boolean animalValido = false;
            do {
                System.out.println("Ingrerse el nombre y su raza de animal que quieres asociar a un cuidador: ");
                String nombre = sc.next();

                if (animalesRescatados.contains(nombre)) {
                    System.out.println("Ingrese el cuidador que quieres asociar a este animal: " + nombre);
                    String cuidador = sc.next();
                    relacion.put(nombre, cuidador);
                    System.out.println("Relacion asignada correctamente");
                    animalValido = true;
                } else {
                    System.out.println("Ese animal no está en la lista de rescatados.");
                    animalValido = false;
                }
            } while (!animalValido);

            System.out.println(relacion);

            boolean respuestaValida = false;
            do {
                System.out.println("Desea ingresar algun animal mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("La respuesta introducida es incorrecta, debe de ser SI o NO, intentalo de nuevo");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));

    }

    private static void pasarAnimalColaEsperaAdopcio() {
        String respuesta;
        do{

            boolean animalValido = false;
            do {
                System.out.println("Ingresa el animal que quieres pasar a la cola: ");
                String animal = sc.next();

                if (animalesRescatados.contains(animal)) {
                    colaAdopcion.add(animal);
                    animalValido = true;
                    System.out.println("Animal añadido correctamente");
                }else{
                    System.out.println("Ese animal no está en la lista de rescatados");
                    animalValido = false;
                }
            }while(!animalValido);

            System.out.println(colaAdopcion);

            boolean respuestaValida = false;
            do {
                System.out.println("Desea añadir algun animal mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("La respuesta introducida es incorrecta, debe de ser SI o NO, intentalo de nuevo");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));

    }

    private static void adoptarAnimal() {
        String respuesta;
        do{

            if(colaAdopcion.isEmpty()){
                System.out.println("No hay animales para adoptar");
            }else{
                String adoptado = colaAdopcion.poll();
                System.out.println("El animal adoptado a sido el: " +adoptado);

                //hay que leinimarlo tambien de las demas listas, porq ya no estara en el refugio
                animalesRescatados.remove(adoptado);
                relacion.remove(adoptado);
            }

            boolean respuestaValida = false;
            do {
                System.out.println("Desea adoptar algun animal mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("La respuesta introducida es incorrecta, debe de ser SI o NO, intentalo de nuevo");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));
    }

    private static void listaAnimalesCuidadores() {
        System.out.println("Lista de animales cuidadores ahora mismo seria de: " + relacion);
    }
}