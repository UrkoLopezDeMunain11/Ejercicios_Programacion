package org.example.almacen.Controladores.Vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.example.almacen.Controladores.Modelo.AlmacenController;
import org.example.almacen.Modelo.Producto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlmacenViewController {

    @FXML
    private Button bAceptar;
    @FXML
    private Button bCancelar;

    @FXML
    private CheckBox cbProntoPago;

    @FXML
    private ComboBox<String> cbProveedores;

    @FXML
    private CheckBox cbVolumen;

    @FXML
    private ToggleGroup gOperacion;

    @FXML
    private TitledPane pCompra;

    @FXML
    private TitledPane pOperacion;

    @FXML
    private HBox hbBotones;

    @FXML
    private TitledPane pVenta;

    @FXML
    private RadioButton rbCompra;

    @FXML
    private RadioButton rbVenta;

    @FXML
    private TextField tfCliente;

    @FXML
    private TextField tfImporteCompra;

    @FXML
    private TextField tfImporteVenta;

    @FXML
    private TextField tfNombreProducto;

    @FXML
    private TextField tfPrecio;

    @FXML
    private TextField tfPrecioVenta;

    @FXML
    private TextField tfUnidades;

    private String operacion = "";

    @FXML
    void aceptar(ActionEvent event) {
        // Actualizar la base de datos con los datos de la compra o de la venta.
        if(operacion.isEmpty()){
                mostrarAlerta("Error", "Debe seleccionar una operación (Compra o Venta)", Alert.AlertType.ERROR);
                return;
        }


            String nombreProducto = tfNombreProducto.getText();
            String unidades = tfUnidades.getText();
            String precio = operacion.equals("Compra") ? tfPrecio.getText() : tfPrecioVenta.getText();
            String cliente = tfCliente.getText();
            String proveedor = cbProveedores.getValue();
            String importe = operacion.equals("Compra") ? tfImporteCompra.getText() : tfImporteVenta.getText();


        try
        {
            if (operacion.equals("Compra"))
            {
                AlmacenController.registrarCompra(nombreProducto, unidades, precio, proveedor, importe);
            }
            else
            {
                AlmacenController.registrarVenta(nombreProducto, unidades, precio, cliente, importe);
            }
            mostrarAlerta("Éxito", operacion + " registrada correctamente", Alert.AlertType.INFORMATION);
            limpiarCampos(); //para limpiar las cajas, lo que se alla puesto dentro que desaparezca
        }
        catch (Exception ex)
        {
            mostrarAlerta("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }

        mostrarAlerta("Éxito", "producto corecto", Alert.AlertType.INFORMATION);


    }

    @FXML
    void cancelar(ActionEvent event) {
        // Acabar sin guardar cambios.
        System.exit(0);

    }





    @FXML
    void activarCompra(ActionEvent event) {
        // Habilitar los campos de compra y deshabilitar los de venta.
        try
        {
            operacion = "Compra";
            pCompra.setVisible(true);
            pVenta.setVisible(false);
            colocarBotones(pCompra.getPrefHeight());
            cbProveedores.getItems().clear();
            // LLenar combo
            AlmacenController.llenarCombo(cbProveedores);
            tfPrecio.requestFocus();
        }
        catch (Exception ex)
        {
            mostrarAlerta("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }


    @FXML
    void activarVenta(ActionEvent event) {
        // Habilitar los campos de venta y deshabilitar los de compra.
        try
        {
            operacion = "Venta";
            pCompra.setVisible(false);
            pVenta.setVisible(true);
            colocarBotones(pVenta.getPrefHeight());
        }
        catch (Exception ex)
        {
            mostrarAlerta("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }


    // DESCUENTOS

    private void calcularImporteVenta() {
        try {
            double precio = Double.parseDouble(tfPrecioVenta.getText());
            int cant = Integer.parseInt(tfUnidades.getText());
            double total = precio * cant;

            if (cbVolumen.isSelected()) total *= 0.98; // -2% para el meodo aplicarDescuentoPorVolumen
            if (cbProntoPago.isSelected()) total *= 0.97; // -3% para el metodo aplicarDescuentoProntoPago

            tfImporteVenta.setText(String.format("%.2f", total));
        } catch (NumberFormatException e) {
            tfImporteVenta.setText("0.00");
        }
    }

    @FXML
    void aplicarDescuentoPorVolumen(ActionEvent event) {
        // Aplicar un descuento del 2% al importe de la venta
        calcularImporteVenta();


    }

    @FXML
    void aplicarDescuentoProntoPago(ActionEvent event) {
        // Aplicar un descuento del 3% al importe de la venta
        calcularImporteVenta();

    }



    // VALIDACIONES

    @FXML
    void validarCliente(ActionEvent event) {
        // Comprobar que es un nombre válido. Se puede alagar el ejercicio buscando en base de datos, insertando si no está, ....
        if (tfCliente.getText().trim().isEmpty()) {
            mostrarAlerta("Validación", "El nombre del cliente no puede estar vacío", Alert.AlertType.WARNING);
            tfCliente.requestFocus();
        }
    }

    @FXML
    void validarPrecioCompra(ActionEvent event) {
        // Comprobar que el precio de compra es un número positivo.
        try {
            double precio = Double.parseDouble(tfPrecio.getText());
            if (precio <= 0) throw new Exception();

            int cant = Integer.parseInt(tfUnidades.getText());
            tfImporteCompra.setText(String.valueOf(precio * cant));
        } catch (Exception e) {
            mostrarAlerta("Error", "El precio debe ser un número positivo", Alert.AlertType.ERROR);
            tfPrecio.requestFocus();
        }
    }

    private int unidades;
    @FXML
    void validarUnidades(ActionEvent event) {
        // Comprobar que las unidades son un número entero positivo.
        try
        {
            unidades = Integer.parseInt(tfUnidades.getText());
            if (unidades <= 0)
                throw new Exception("Las unidades son un campo numérico mayor que cero");
        }
        catch(Exception e)
        {
            mostrarAlerta("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
            tfUnidades.requestFocus();
        }

    }

    @FXML
    void validarYBuscarProducto(ActionEvent event) {
        // Comprobar que es texto y que existe en la base de datos.
        try
        {
            String nombre = tfNombreProducto.getText();
            if (nombre.isEmpty())
                throw new Exception("El nombre del producto es un campo obligatorio");
            Pattern pat = Pattern.compile("^[A-Z][a-z]*$");
            Matcher mat = pat.matcher(nombre);
            if (!mat.matches())
                throw new Exception( "El nombre del producto no tiene un formato adecuado");

            // buscar en la base de datos el producto
            AlmacenController.buscarProducto(nombre);
        }
        catch(Exception e)
        {
            mostrarAlerta("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
            tfNombreProducto.requestFocus();
        }

    }

    // para el cuadro de alerta q salte si has metido algo mal o si se ha relaizado exitosamente, depende
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    // para limpiar las cajas, para borrar lo que has puesto dentro y no se quede ahi, no se queden los productos puestos anteriormente
    private void limpiarCampos() {
        tfNombreProducto.clear();
        tfUnidades.clear();
        tfPrecio.clear();
        tfPrecioVenta.clear();
        tfCliente.clear();
        tfImporteCompra.clear();
        tfImporteVenta.clear();
        cbVolumen.setSelected(false);
        cbProntoPago.setSelected(false);
    }

    // Se ejecuta automáticamente al cargar el FXML
    @FXML
    public void initialize() {
        // Evento de foco perdido. No está en sceneBuilder
        tfNombreProducto.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // el campo perdió el foco
                validarYBuscarProducto(null); // reutiliza el mismo método
            }
        });

        pCompra.setVisible(false);
        pVenta.setVisible(false);
        colocarBotones(0); // sin panel visible, altura 0
    }

    private static final double LAYOUT_Y_PANELES = 253.0;  // layoutY de pCompra y pVenta
    private static final double MARGEN = 15.0;

    private void colocarBotones(double alturaPanelVisible)
    {
        hbBotones.setLayoutY(LAYOUT_Y_PANELES + alturaPanelVisible + MARGEN);
    }
}
