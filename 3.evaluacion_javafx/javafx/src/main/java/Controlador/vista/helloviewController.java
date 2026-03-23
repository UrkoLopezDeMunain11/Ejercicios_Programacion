package Controlador.vista;

import Controlador.PersonaController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class helloviewController {

    @FXML
    private Button bGuardar;

    @FXML
    private Button bsalir;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfTelefono;


    @FXML
    private TextField tfEdad;

    @FXML
    private TextField tfDNI;

    @FXML
    private DatePicker dpFechaNacimiento;

    @FXML
    void onGuardarPersona (ActionEvent event) {
        String nombre = tfNombre.getText();// get text es coger lo que hay dentro
        String apellido = tfApellido.getText();
        String telefono = tfTelefono.getText();
        int edad = Integer.parseInt(tfEdad.getText());
        String dni = tfEdad.getText();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();

        validarNombre(nombre);
        validarApellido(apellido);
        validarDNI(dni);
        validarTelefono(telefono);
        validarEdad(edad);


        PersonaController.insertarPersona(nombre, apellido,dni, telefono,fechaNacimiento,edad);


    }

    void onSalir(ActionEvent event){
        System.exit(0);
    }

    void onActualizar(ActionEvent event){
        String nombre = tfNombre.getText();// get text es coger lo que hay dentro
        String apellido = tfApellido.getText();
        String telefono = tfTelefono.getText();
        int edad = Integer.parseInt(tfEdad.getText());
        String dni = tfEdad.getText();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();

        validarNombre(nombre);
        validarApellido(apellido);
        validarDNI(dni);
        validarTelefono(telefono);
        validarEdad(edad);


        PersonaController.ActualizarPersona(nombre, apellido,dni, telefono,fechaNacimiento,edad);


    }

    void onborrar(ActionEvent event){
        String dni = tfDNI.getText();

        if (dni.isEmpty()) {
            System.err.println("Debes introducir un DNI para borrar.");
            return;
        }

        // Opcional: Pedir confirmación (muy recomendado para no borrar por error)
        if (confirmarAccion("¿Estás seguro de que quieres borrar a esta persona?")) {
            boolean eliminado = PersonaController.eliminarPersona(dni);

            if (eliminado) {
                System.out.println("Persona eliminada correctamente.");
            } else {
                System.err.println("No se encontró a nadie con ese DNI.");
            }
        }

    }

    private void validarNombre(String nombre) {
        boolean nombreValido = false;
        do {
            Pattern p = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúñÑ]");
            Matcher m = p.matcher(nombre);
            if (m.matches()) {
                nombreValido = true;
            }
        }while (!nombreValido);

    }

    private void validarApellido(String apellido) {
        boolean apellidoValido = false;
        do {
            Pattern p = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúñÑ]");
            Matcher m = p.matcher(apellido);
            if (m.matches()) {
                apellidoValido = true;
            }
        }while (!apellidoValido);
    }

    private void validarDNI(String dni) {
        boolean dniValido = false;
        do {
            Pattern p = Pattern.compile("^[0-9]{8}[A-Za-z]$");
            Matcher m = p.matcher(dni);
            if (m.matches()) {
                dniValido = true;
            }
        }while (!dniValido);
    }

    private void validarTelefono(String telefono) {
        boolean telefonoValido = false;
        do {
            Pattern p = Pattern.compile("\"^[0-9]{9}$");
            Matcher m = p.matcher(telefono);
            if (m.matches()) {
                telefonoValido = true;
            }
        }while (!telefonoValido);
    }

    private void validarEdad(int edad) {
        boolean edadValida = false;
        do {
            if (edad > 0) {
                edadValida = true;
            }
        }while(!edadValida);
    }

    private boolean confirmarAccion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar acción");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        return alert.showAndWait().filter(r -> r == ButtonType.OK).isPresent();
    }

}
