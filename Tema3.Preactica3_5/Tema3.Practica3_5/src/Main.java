import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //map mes y dia
    //array con  los meses
    //para gurdar la info del total gastado en cada mes --> map mes clave    valor lo gastado
    static Scanner sc = new Scanner(System.in);
    static String[]meses = {"enero","febrero","marzo","abril","mayo","junio",
            "julio","agosto","septiembre","octubre","noviembre","diciembre"};
    static Map<String, Integer> map = new HashMap<>();
    static int cantidad;

    public static void main(String[] args) {
        try {
            introducirValores();
            ordenar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }


    private static void introducirValores() {
        String respuesta;
        int dia;
        do {
            boolean numeroValido = false;
            int numeroMes;

            boolean diaValido = false;
            do {
                try {
                    System.out.println("Introduce el dia: ");
                    dia = sc.nextInt();
                    diaValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERROR");
                    sc.next();
                    diaValido = false;
                }
            }while(!diaValido);


            do {
                System.out.println("Introduce el numero dl mes del 1 al 12: ");
                numeroMes = sc.nextInt();

                System.out.println("Introduce la cantidad pagada: ");
                cantidad = sc.nextInt();
                sc.nextLine();
                numeroValido = true;

                if (numeroMes < 1 || numeroMes > 12) {
                    System.out.println("Número de mes inválido. Intenta de nuevo.");
                    numeroValido = false;
                }
            } while (!numeroValido);

            String mes = meses[numeroMes - 1];//Ejemplo: meses[3-1] → meses[2] entonces gurdara en esa nueba variable el mes marszo q es el que esta en laposixion 2

            map.put(mes, map.getOrDefault(mes, 0) + cantidad);//para no sobreescribir si se repite el mes, asi suma todas las cantidades del mimsom mes
            System.out.println("El map contiene: " + map);


            boolean respuestaValida = false;
            do {
                System.out.println("Quiere introducir mas?(SI/NO)");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("Respuesta incorrecta, introduce solo SI o NO");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("Si"));
        System.out.println("Totales por mes: " + map);
    }

    private static void ordenar() {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(map.entrySet());

        Collections.sort(lista, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));

        System.out.println(lista.toString());

    }

}