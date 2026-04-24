package org.huellasanas.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.huellasanas.config.DbConfig;
import org.huellasanas.util.SceneManager;
import java.sql.*;

public class LoginController {
    @FXML private TextField txtId;
    @FXML private ComboBox<String> cmbRol;

    @FXML public void initialize() {
        cmbRol.getItems().addAll("Cliente", "Veterinario");
    }

    @FXML public void handleLogin() {
        String id = txtId.getText();
        String rol = cmbRol.getValue();
        if(id.isEmpty() || rol == null) return;

        String table = rol.equals("Cliente") ? "cliente" : "veterinario";
        String query = "SELECT * FROM " + table + " WHERE id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            if (pstmt.executeQuery().next()) {
                String vista = rol.equals("Cliente") ? "dashboard-cliente.fxml" : "dashboard-veterinario.fxml";
                SceneManager.loadScene((Stage) txtId.getScene().getWindow(), vista);
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML public void handleRegister() { /* Lógica de registro aquí */ }
}