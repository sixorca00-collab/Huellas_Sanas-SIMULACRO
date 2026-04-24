package org.huellasanas.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.huellasanas.models.Cliente;
import org.huellasanas.services.ClienteService;
import org.huellasanas.util.Session;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class LoginClienteController {

    @FXML
    private TextField txtId;

    private ClienteService clienteService = new ClienteService();

    @FXML
    private void entrar(ActionEvent event) {

        String input = txtId.getText();

        if (input.isEmpty()) {
            mostrarError("Ingrese un ID");
            return;
        }

        Optional<Cliente> opCliente =
                clienteService.buscarClientePorId(input);

        if (opCliente.isEmpty()) {
            mostrarError("Cliente no existe");
            return;
        }

        Cliente cliente = opCliente.get();

        Session.loginCliente(cliente);

        cambiarVista(event, "dashboard-cliente.fxml");
    }

    private void mostrarError(String msg) {
        System.out.println("ERROR: " + msg);
    }

    private void cambiarVista(ActionEvent event, String fxml) {
        try {
            String ruta = "/org/huellassanas/views/" + fxml;

            URL url = getClass().getResource(ruta);

            System.out.println("Intentando cargar: " + ruta);
            System.out.println("URL encontrada: " + url);

            if (url == null) {
                System.out.println(" FXML NO ENCONTRADO");
                return;
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            System.out.println("ERROR CARGANDO FXML");
            e.printStackTrace();
        }
    }
}