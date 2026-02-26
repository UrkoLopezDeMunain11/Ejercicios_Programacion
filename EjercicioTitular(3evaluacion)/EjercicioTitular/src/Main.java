import Vista.MostrarElMenu;

public class Main {
    public static void main(String[] args) {
        // creo una nueva para poder llamar al menu general del ejericio q estara en la vista y luego de ahi si que llamara a lo demas, pero aqui en el main solo llamar al menu de la vista
        MostrarElMenu menu = new MostrarElMenu();// crear el primer elemento de la vista que hace falta
        menu.mostrarMenu();// y llma al menu de la vista
    }
}