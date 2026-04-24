package org.huellasanas.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.huellasanas.models.Cliente;

public class ClienteController {

    // ESTOS DEBEN COINCIDIR EXACTAMENTE CON LOS fx:id DEL FXML
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colCorreo;

    @FXML
    public void initialize() {
        // Enlazar columnas con los atributos de tu modelo Cliente
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        // Opcional: Aquí podrías cargar los datos de la DB
        // tablaClientes.setItems(FXCollections.observableArrayList(clienteService.listarClientes()));
    }
}