package org.huellasanas.services;

import org.huellasanas.DAO.Impl.CitasDAO;
import org.huellasanas.models.Cita;
import org.huellasanas.models.Mascota;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CitaService {
    private final CitasDAO citDAO = new CitasDAO();
    private final MascotaService mascotaService = new MascotaService();

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
        if (cita.getId() <= 0 ){
        }
        return false;
    }
    //Delete
    public boolean eliminarCita(int id){
        if (id <= 0 ){
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

    //Cita por cliente
   public List<Cita> citasPorCliente(String clienteId){
        List<Mascota> mascotas = mascotaService.listarMascotasPorCliente(clienteId);
        List<Integer> idsMascotas = mascotas.stream().map(Mascota::getId).toList();

        return citDAO.findAll().stream().filter(c -> idsMascotas.contains(c.getMascotaId())).toList();

   }
}
