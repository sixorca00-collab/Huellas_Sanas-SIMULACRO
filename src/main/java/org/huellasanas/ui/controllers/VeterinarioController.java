package org.huellasanas.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.huellasanas.util.SceneManager;

public class VeterinarioController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    public void initialize() {
        cargarVista("citas-veterinario.fxml");
    }

    private void cargarVista(String fxml) {
        try {
            // Verifica que la carpeta en resources sea realmente 'huellasanas' (con 'ss')
            String path = "/org/huellassanas/views/" + fxml;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            contentPane.getChildren().setAll((Node) loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void verCitas() {
        cargarVista("citas-veterinario.fxml");
    }

    @FXML
    public void verClientes() {
        cargarVista("clientes.fxml");
    }

    @FXML
    public void cerrarSesion() {
        Stage stage = (Stage) contentPane.getScene().getWindow();
        SceneManager.loadScene(stage, "login.fxml");
    }
}