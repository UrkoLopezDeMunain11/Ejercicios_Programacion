import Modelo.Directivo;
import Modelo.Empleado;
import Modelo.Persona;


public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Ana", 25, 1200);
        Empleado e2 = new Empleado("Jose", 30, 1300);
        Empleado e3 = new Empleado("Lucia", 22, 1100);

        Directivo dir1 = new Directivo("Urko", 21,555,"Gerente");
        dir1.subordinados.add(e1);
        dir1.subordinados.add(e2);

        Directivo dir2 = new Directivo("Maria", 50, 5000, "CEO");
        dir2.subordinados.add(e1);
        dir2.subordinados.add(e2);
        dir2.subordinados.add(e3);


        Directivo[] directivos = {dir1, dir2};
        Directivo masSubordinado = directivos[0];

        for (Directivo d : directivos) {
            if (d.subordinados.size() > masSubordinado.subordinados.size()) {
                masSubordinado = d;
            }
        }

        Persona masSubordinados = null;
        System.out.println("El directivo con más subordinados es: " + masSubordinados.getNombre());
        System.out.println("Datos: " + masSubordinados.toString());
    }
}
