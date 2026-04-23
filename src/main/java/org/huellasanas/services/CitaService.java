package org.huellasanas.services;

import org.huellasanas.DAO.Impl.CitasDAO;
import org.huellasanas.models.Cita;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CitaService {
    private final CitasDAO citDAO = new CitasDAO();

    public boolean agendarCita(Cita cita) {
        //No permitir citas para el pasado
        if (cita.getFechaHora().isBefore(LocalDateTime.now())) {
            return false;
        }
        //No permitir citas para el mismo veterinario en el mismo horario
        if (ExisteCita(cita)){
            System.out.println("Ya existe una cita para ese tiempo");
            return false;
        }
        return citDAO.save(cita);
    }
    //Ver citas
    public Optional<Cita> verCitasPorId(int id) {
        return citDAO.findById(id);
    }
    //ver todas las citas
    public List<Cita> verTodasLasCitas() {
        return citDAO.findAll();
    }
    //Update
    public boolean actualizarCita(Cita cita){
        if (cita.getId() < 0 ){
            System.out.println("Ingrese numero valido");
        }
        return false;
    }
    //Delete
    public boolean eliminarCita(int id){
        if (id < 0 ){
            System.out.println("Ingrese numero valido");
            return false;
        }
        return citDAO.delete(id);
    }
    //Existe cita?
    public boolean ExisteCita(Cita newCita){
        List<Cita> citas = citDAO.findAll();

        //Valido
        return citas.stream().anyMatch(c ->
            c.getVeterinarioId().equals(newCita.getVeterinarioId()) && c.getFechaHora().equals(newCita.getFechaHora())
        );
    }
}
