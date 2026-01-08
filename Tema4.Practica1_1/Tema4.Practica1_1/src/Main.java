import Modelo.Circunferencia;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circunferencia c1 = new Circunferencia(5.2);
        Circunferencia c2 = new Circunferencia(7.2);

        System.out.println("Lonngitud de la pimera circunferencia es: " + c1.calcularVolume());
        System.out.println("Area de la primera circunferencia seria de : " + c1.calcularArea());
        System.out.println("Volumen de la primera circunferencia seria de: " + c1.calcularVolume());
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Lonngitud de la segunda circunferencia es: " + c2.calcularVolume());
        System.out.println("Area de la segunda circunferencia seria de : " + c2.calcularArea());
        System.out.println("Volumen de la segunda circunferencia seria de: " + c2.calcularVolume());
    }
}