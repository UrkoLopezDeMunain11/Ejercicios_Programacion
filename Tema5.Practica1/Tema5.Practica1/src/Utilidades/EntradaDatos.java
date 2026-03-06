package Utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntradaDatos {
    static Scanner sc = new Scanner(System.in);
    public static String pedirDniValido() {
        String dni;
        boolean dniValido = false;
        do {
            System.out.println("Ingrese el DNI del pasajero:");
            dni = sc.next();
            Pattern pt = Pattern.compile("^\\d{7,8}$");
            Matcher mat = pt.matcher(dni);
            if (mat.find()) {
                dniValido = true;
            }else{
                dniValido = false;
                System.out.println("vueñve a intentarlo");
            }
        }while(!dniValido);
        return dni;
    }
}
