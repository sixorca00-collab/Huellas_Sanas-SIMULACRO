package org.huellasanas.services;

import org.huellasanas.DAO.Impl.VeterinarioDAO;
import org.huellasanas.models.Veterinario;

import java.util.List;
import java.util.Optional;

public class VeterinarioService {
    private final VeterinarioDAO vDAO = new VeterinarioDAO();

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
}
