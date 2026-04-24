package org.huellasanas;

import javafx.application.Application;
import javafx.stage.Stage;
import org.huellasanas.util.SceneManager; // Verifica que este import sea correcto

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Asegúrate de que login.fxml esté exactamente en /org/huellasanas/views/
        SceneManager.loadScene(stage, "login.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}