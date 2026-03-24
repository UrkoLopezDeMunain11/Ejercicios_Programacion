package Controlador.vista;

import Controlador.PersonaController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

// tienen q ser estos tres import para q luego s¡en limpiarcajas te deje usar el clear
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


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

        // esto para q salga un cuandro de dialogo dandote la confirmacion
        confirmarAccion("Persona guardada");

        // esto para q una vez q le hayas dado al botos de guardar, se quite el texto q le has puestoa cada caja
        limpiarcajas();


    }

    @FXML
    void onSalir(ActionEvent event){
        System.exit(0);

        confirmarAccion("Saliendo del programa");
    }

    @FXML
    void onActualizar(ActionEvent event){
        String nombre = tfNombre.getText();// get text es coger lo que hay dentro, de lo que se ha escrito dentro de la casaj de texto de la vientana q he creado
        String apellido = tfApellido.getText();
        String telefono = tfTelefono.getText();
        int edad = Integer.parseInt(tfEdad.getText());
        String dni = tfEdad.getText();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();

        // una vez tenido los daots hay q validarlos
        validarNombre(nombre);
        validarApellido(apellido);
        validarDNI(dni);
        validarTelefono(telefono);
        validarEdad(edad);


        PersonaController.ActualizarPersona(nombre, apellido,dni, telefono,fechaNacimiento,edad);

        confirmarAccion("Persona actualizada");
        //confirmarAccion(); asi en caso de q el contexttext tenga ya un mensaje por defecto para todos

        limpiarcajas();



    }

    @FXML
    void onBorrar(ActionEvent event){
        String dni = tfDNI.getText();

        if (dni.isEmpty()) {
            System.err.println("Debes introducir un DNI para borrar.");
            return;
        }


        confirmarAccion("Persona borrada");

        limpiarcajas();

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

    // esta alerta es para q depsues de meter los datos te salga un cuadrado con mensaje de confirmacion, de que se ha hecho
    private boolean confirmarAccion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // aqui lo crea
        alert.setTitle("Confirmar acción"); // este sera el titulo de la ventana
        alert.setHeaderText(null); // no es obligatorio es para que la ventana quede mas bonita. Quita el espacio de arriba
        // alert.setHeaderText("¡Atención!");  Texto en negrita
        alert.setContentText(mensaje);// este es el mensaje que saldra a la hora de llamar ha este metodo que sera el mensaje q le hemos psado de cada uno a la hora de llmar ha etse metodo
        // alert.setContentText("Confirmación de la acción"); tambien se puede pponer directamente texto aqui y de los otros metodos solollamarle a este metodo sin pasarle mensaje y saldra este mensaje para todos el mismo, el otro es para q cada uno le mande el mensaje suyo presonalizado
        return alert.showAndWait().filter(r -> r == ButtonType.OK).isPresent();// es para el boton q le das y para continuar, salir del cuadro de mensaje de la alarma, sin esto no iria ese boton
    }


    // esto es para limpiar las cajas de los textos que has puesto dentro una vez hayas actualizado borrado , guardado, salido
    @FXML
    private void limpiarcajas(){
        tfNombre.clear();
        tfApellido.clear();
        tfDNI.clear();
        tfEdad.clear();
        tfTelefono.clear();
        dpFechaNacimiento.setValue(null); // Para los DatePicker se usa setValue(null)
    }

}
