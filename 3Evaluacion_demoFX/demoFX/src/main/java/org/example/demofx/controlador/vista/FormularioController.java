package org.example.demofx.controlador.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.demofx.controlador.modelo.PersonaController;

import java.time.LocalDate;

public class FormularioController {

        @FXML
        private Button bGuardar;

        @FXML
        private Button bSalir;

        @FXML
        private DatePicker dpFechaNacimiento;

        @FXML
        private TextField tfApellidos;

        @FXML
        private TextField tfDni;

        @FXML
        private TextField tfEdad;

        @FXML
        private TextField tfNombre;

        @FXML
        private TextField tfTelefono;

    @FXML
    void onSalir(ActionEvent event) {

    }

    @FXML
    void ongGuardarPersona(ActionEvent event) {
        // 1. Obtener los datos
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        String dni = tfDni.getText();
        String telefono = tfTelefono.getText();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();
        int edad = Integer.parseInt(tfEdad.getText());

        // 2. Validar
        try
        {
            validarNombre(nombre);
            validarApellidos(apellidos);
            validarDNI(dni);
            validarTelefono(telefono);
            // La fecha viene del datepicker
            validarEdad(edad);
        }
        catch(Exception e)
        {
            mostrarAlerta("Error de Validación", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
        }

        // 3. Si todo está bien, procedemos con el Modelo y el DAO
        PersonaController.insertarPersona(nombre, apellidos,dni, telefono,fechaNacimiento,edad);

        mostrarAlerta("Éxito", "Persona guardada correctamente", Alert.AlertType.INFORMATION);
    }

    public void validarNombre(String nombre) throws Exception {
        if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ]{2,30}$")) {
            throw new Exception("Nombre inválido");
        }
    }

    public void validarApellidos(String apellidos) throws Exception {
        if (!apellidos.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,60}$")) {
            throw new Exception("Apellidos inválidos");
        }
    }

    public void validarDNI(String dni) throws Exception {
        if (!dni.matches("^[0-9]{8}[A-Za-z]$")) {
            throw new Exception("DNI inválido");
        }
    }

    public void validarTelefono(String telefono) throws Exception {
        if (!telefono.matches("^[6789][0-9]{8}$")) {
            throw new Exception("Teléfono inválido");
        }
    }

    public void validarEdad(int edad) throws Exception {
        if (edad < 0)
            throw new Exception("Edad no válida");
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }
}
