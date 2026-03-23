module org.example.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.demofx to javafx.fxml;
    exports org.example.demofx;

    // Permite que JavaFX acceda a tu Controlador
    exports org.example.demofx.controlador.vista;
    opens org.example.demofx.controlador.vista to javafx.fxml;
}