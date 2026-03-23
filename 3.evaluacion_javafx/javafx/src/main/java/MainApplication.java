
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class MainApplication {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/org/example/demofx/vista/FormularioPersona.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440); // lara darle tamaño a la ventana
        stage.setTitle("Personas"); // el titulo q quiero q tenga
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
