package org.huellasanas.ui.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.huellasanas.DAO.Impl.CitasDAO;
import org.huellasanas.models.Cita;

public class CitasController {
    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colFecha;
    @FXML private TableColumn<Cita, String> colVeterinario;
    @FXML private TableColumn<Cita, String> colEstado;

    private final CitasDAO cDAO = new CitasDAO();

    @FXML
    public void initialize() {
        // Enlaza las columnas con los atributos de tu clase Cita.java
        // Asegúrate de que los nombres "fechaHora", "veterinarioId", "estado"
        // coincidan con los getters de tu modelo Cita.
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
        colVeterinario.setCellValueFactory(new PropertyValueFactory<>("veterinarioId"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Carga los datos
        tablaCitas.setItems(FXCollections.observableArrayList(cDAO.findAll()));
    }
}