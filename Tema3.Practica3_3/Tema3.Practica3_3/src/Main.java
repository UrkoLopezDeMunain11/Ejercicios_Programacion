import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Stack<String> pila = new Stack<>();
    public static void main(String[] args) {

        int opcion = 0;
        do {
            try {
                System.out.println("----------------------MENU----------------------");
                System.out.println("1- Añadir un libro a la pila");
                System.out.println("2- Consultar el libro en la parte superior");
                System.out.println("3- Retirar el libro en la parte superior");
                System.out.println("4- Mostrar todos los libros en la pila");
                System.out.println("5- Verificar si la pila está a vacía");
                System.out.println("6- Salir del programa");
                System.out.println("------------------------------------------------");
                System.out.println("Introduce una opcion:");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        añadirUnLibroPila();
                        break;
                    case 2:
                        consultarLibroParteSuperior();
                        break;
                    case 3:
                        retirarlibroParteSuperior();
                        break;
                    case 4:
                        mostrarTodosLibrosEnLaPila();
                        break;
                    case 5:
                        verificarSiPilaEstaVacia();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opcion introducida incorrecta");
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR");
                sc.next();
            }
        } while (opcion != 6);


    }

    private static void añadirUnLibroPila() {
        String respuesta;
        do {
            System.out.println("Introduce el libreo que quieres añadir a la pila: ");
            String libro = sc.next();
            pila.push(libro);
            System.out.println("Libro añadido correctamente" + pila);

            boolean respuestaValida = false;
            do {
                System.out.println("Desea añadir algun libro mas a la pila? (SI/NO)");
                respuesta = sc.next();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Respuesta incorrecta");
                    respuestaValida = false;
                } else {
                    respuestaValida = true;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));

    }

    private static void consultarLibroParteSuperior() {

        if (!pila.isEmpty()) {
            System.out.println("El titulo del libro de la parte superior es: " +pila.peek());
        } else {
            System.out.println("La pila de libros esta vacia, debe intorducir libros");
        }
    }

    private static void retirarlibroParteSuperior() {
        String libroRetirado = pila.pop();//guardo el libro q elimino en otra variable para luego poder mostrr el libro q he eliminado
        System.out.println("Libro"+" "+ libroRetirado +" "+ "retirado correctamente");//muestro el libro retirado
        System.out.println("La pila de libros quedaria asi: " + pila);//muesro la pila despues de borrar el ultimo libro, ese ya no a`parecera
    }

    private static void mostrarTodosLibrosEnLaPila() {
        if (!pila.isEmpty()) {
            System.out.println("Lista de libros añadidios del mas reciente al mas antiguo");
            for(int i = pila.size()-1; i >= 0; i--) {
                //i-- porq vamos de ariba a abajo el la pila
                //pila.size es la longitud de la fila -1 para empezar en el ultimo. pila.size(9 no devuelve numero toatal de elemntos en la pila y -1 para emepzezar en el ultimo
                //i >= 0 miwentras no se menor q el ultimo indice q es 0 , si es -1 ya , fallaria el bucle
                System.out.println((pila.size()-i) +" "+ pila.get(i));
            }
        }else {
            System.out.println("Pila vacia, debes meter elementos antes a la pila");
        }
    }

    private static void verificarSiPilaEstaVacia() {

        if (pila.isEmpty()) {
            System.out.println("¿La pila esta vacia? " + pila.isEmpty());
        } else {
            System.out.println("¿La pila esta vacia? " + pila.isEmpty());
        }
    }
}