package org.huellasanas.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import org.huellasanas.models.Cliente;

import org.huellasanas.util.Session;

import java.io.IOException;

public class DashboardClienteController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    public void initialize() {
        Cliente cliente = Session.getCliente();

        System.out.println("Cliente logueado: " + cliente.getNombre());

        // Cargar vista inicial (opcional)
        cargarVista("mascotas-cliente.fxml");
    }

    private void cargarVista(String fxml) {
        String ruta = "./org/huellassanas/views/" + fxml;
        java.net.URL url = getClass().getResource(ruta);

        System.out.println("Buscando en ruta: " + ruta);
        System.out.println("¿Encontró el archivo?: " + (url != null));

        if (url == null) {
            System.err.println("¡ERROR! No se pudo encontrar el archivo en: " + ruta);
            return; // Detener para que no falle el programa
        }

        try {
            FXMLLoader loader = new FXMLLoader(url);
            Node vista = loader.load();
            contentPane.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void verMascotas() {
        cargarVista("mascotas-cliente.fxml");
    }

    @FXML
    private void verCitas() {
        cargarVista("citas-cliente.fxml");
    }
}