package org.huellasanas.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {
    // IMPORTANTE: static y public
    public static void loadScene(Stage stage, String fxmlFile) {
        try {
            // Ajusta la ruta base. Debe coincidir con la carpeta real en src/main/resources
            String path = "/org/huellassanas/views/" + fxmlFile;

            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(path));

            // Debug rápido: si esto da error, es que la ruta está mal
            if (SceneManager.class.getResource(path) == null) {
                System.err.println("ERROR: No se encontró el archivo en " + path);
                return;
            }

            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.err.println("ERROR al cargar FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}