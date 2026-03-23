package Controlador.vista;

import Controlador.PersonaController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
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



}
