package org.huellasanas.services;

import org.huellasanas.DAO.Impl.CitasDAO;
import org.huellasanas.DAO.Impl.VeterinarioDAO;
import org.huellasanas.models.Cita;
import org.huellasanas.models.Veterinario;

import java.util.List;
import java.util.Optional;

public class VeterinarioService {
    private final VeterinarioDAO vDAO = new VeterinarioDAO();
    private final CitasDAO cDAO = new CitasDAO();

    public boolean crearVeterinario(Veterinario v){
        if (v == null)return false;
        return vDAO.save(v);
    }
    //Listar
    public List<Veterinario> listarVeterinarios(){
        return vDAO.findAll();
    }
    //Por id
    public Optional<Veterinario> buscarVeterinarioPorId(String id){
        return vDAO.findById(id);
    }
    //Actualizar
    public boolean actualizarVeterinario(Veterinario v){
        if (v == null)return false;
        return vDAO.update(v);
    }
    //Eliminar
    public boolean eliminarVeterinario(String id){
        return vDAO.delete(id);
    }

    // Choque de citas
    public boolean choqueCitas(Cita nueva){
        //Validamos datos
        if (nueva == null)return false;

        List<Cita> citas = cDAO.findAll();
        return citas.stream().anyMatch(c -> {
            //Mismo veterinario
            if (!c.getVeterinarioId().equals(nueva.getVeterinarioId())){return false;}
            //Mismo dia
            if (!c.getFechaHora().toLocalDate().equals(nueva.getFechaHora().toLocalDate())){return false;}

            //Choque de tiempo 1Hora margen
            long minutos = Math.abs(
                    java.time.Duration.between(c.getFechaHora(), nueva.getFechaHora()).toMinutes()
            );
            return minutos < 60;
        } );
    }
}
