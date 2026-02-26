package Vista;

import Controlador.TitularController;
import Modelo.Titular;

import javax.swing.*;


public class MostrarElMenu {
    private TitularController titularController;

    public void mostrarMenu() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "------------MENU----------\n" +
                                "1. Agregar titular\n" +
                                "2. Eliminar titular\n" +
                                "3. Modificar titular\n" +
                                "4. Lista\n" +
                                "5. Buscar\n" +
                                "6. Salir\n" +
                                "Seleccione una opción:\n"
                ));

                switch (opcion) {
                    case 1:
                        agregarTitular();
                        break;
                    case 2:
                        eliminarTitular();
                        break;
                    case 3: 
                        modificarTitular();
                        break;
                    case 4:
                       // listaTitulares();
                        break;
                    case 5:
                        buscarTitular();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción del menú.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número válido para seleccionar una opción del menú.");
            }
        } while (opcion != 6);
    }

    private void agregarTitular() {
        JOptionPane.showMessageDialog(null, "----CREAR TITULAR----");// muestro este mensaje por pantalla solo
        String dni = JOptionPane.showInputDialog("Ingrese el DNI del titular:");// pido un dni
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del titular:"); // pido un nombre
        TitularController.creartitular(dni, nombre); // llamo al metodo crear titular con estos datos  que esta en titularcontroller que son los que quiero meter, para q cree estos datos
    }

    private void eliminarTitular() {
        JOptionPane.showMessageDialog(null, "----ELIMINAR TITULAR----");
        String dni = JOptionPane.showInputDialog("Ingrese el DNI del titular:");// pedir el dni para saber de que titular hablas
        if(dni != null) {
            TitularController.eliminarTitular(dni); // que reciba el dni para saber que titular tiene q eliminar
        }
    }

    private void modificarTitular() {
        JOptionPane.showMessageDialog(null, "----MODIFICAR TITULAR----");
        String dni = JOptionPane.showInputDialog("Ingrese el DNI del titular:"); // lo mismo q el de eliminar, q ingrese el dni para saber de que titular estamos hablando
        if (dni != null || !dni.isEmpty()) {// si el dni introducido no es nulo, vacio, exite entrara y lo hara sino no etnrara
            String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre del titular:"); // pedir el nuevo nombre para modificarlo
            String dniNuevo = JOptionPane.showInputDialog("Ingrese el nuevo DNI del titular:"); // pedir el nuevo dni para modificarlo
            TitularController.modificarTitular(dni, dniNuevo, nombreNuevo);// dni es el viejo, q lo necesita mandar al controller para saber qdonde poner el dniNuevo, porq dni cambiarlo
        }
    }


/*
    private void listaTitulares() {
        JOptionPane.showMessageDialog(null, "----LISTA TITULARES----");
        TitularController.listaTitulares();
    }

 */

    private void buscarTitular() {
        JOptionPane.showMessageDialog(null, "----BUSCAR TITULAR----");
        String dni = JOptionPane.showInputDialog("Ingrese el DNI del titular:");
        if (dni != null && !dni.isEmpty()) {
            TitularController.buscar(dni);
        }


    }

}
