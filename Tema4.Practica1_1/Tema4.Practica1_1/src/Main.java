import Modelo.Circunferencia;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circunferencia c1 = new Circunferencia(5.2);
        Circunferencia c2 = new Circunferencia(7.2);

        System.out.println("Radio: " + c1.getRadio());//para ver de cuanto es el radio que he pueesto
        System.out.println("Lonngitud de la pimera circunferencia es: " + c1.calcularVolume());
        System.out.println("Area de la primera circunferencia seria de : " + c1.calcularArea());
        System.out.println("Volumen de la primera circunferencia seria de: " + c1.calcularLongitud());
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Radio: " + c2.getRadio());
        System.out.println("Lonngitud de la segunda circunferencia es: " + c2.calcularVolume());
        System.out.println("Area de la segunda circunferencia seria de : " + c2.calcularArea());
        System.out.println("Volumen de la segunda circunferencia seria de: " + c2.calcularLongitud());
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Calcular volumen, longitud y area, cambiando el radio c1");
        c1.setRadio(8);//para darle un valor al radio c1. En mi caso ya venia con un valor pero al hacer esto ese valor cambia por este
        System.out.println("Radio: " + c1.getRadio());//para ver de cuanto es el radio que he pueesto
        System.out.println("Lonngitud de la pimera circunferencia es: " + c1.calcularVolume());
        System.out.println("Area de la primera circunferencia seria de : " + c1.calcularArea());
        System.out.println("Volumen de la primera circunferencia seria de: " + c1.calcularLongitud());
    }
}