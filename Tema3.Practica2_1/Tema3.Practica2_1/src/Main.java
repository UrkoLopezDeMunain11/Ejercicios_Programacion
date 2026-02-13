//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Float> lista = new ArrayList();
        String respuesta = "";

        do {
            boolean valorValido = false;

            do {
                try {
                    System.out.println("Introduce un valor: ");
                    float valor = sc.nextFloat();
                    sc.nextLine();
                    valorValido = true;
                    lista.add(valor);
                } catch (InputMismatchException var6) {
                    System.out.println("ERROR");
                    sc.nextLine();
                    valorValido = false;
                }
            } while(!valorValido);

            boolean respuestaValida = false;

            do {
                System.out.println("Quieres meter mas valores?(SI/NO): ");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("ERROR");
                    respuestaValida = false;
                } else {
                    respuestaValida = true;
                }
            } while(!respuestaValida);
        } while(!respuesta.equalsIgnoreCase("NO"));

        for(int i = 0; i < lista.size(); ++i) {
            System.out.println("Valor " + i + ": " + String.valueOf(lista.get(i)));
        }

    }
}
