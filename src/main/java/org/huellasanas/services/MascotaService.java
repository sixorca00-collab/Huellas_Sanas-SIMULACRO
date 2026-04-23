package org.huellasanas.services;

import org.huellasanas.DAO.Impl.MascotaDAO;
import org.huellasanas.models.Mascota;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MascotaService {
    private final MascotaDAO mDao= new MascotaDAO();
    //Logica crear mascota
    public boolean crearMascota(Mascota m){
        if (m == null) return false;
        return mDao.save(m);
    }
    //Listar mascota
    public List<Mascota> listarMascotas(){
        return mDao.findAll();
    }

    //Buscar mascota por id
    public Optional<Mascota> buscarMascotaPorId(int id){
        return mDao.findById(id);
    }

    //Actualizar mascota
    public boolean actualizarMascota(Mascota m){
        if (m == null) return false;
        return mDao.update(m);
    }

    //Eliminar mascota
    public boolean eliminarMascota(int id){
        return mDao.delete(id);
    }

    //Mascotas por cliente
    public List<Mascota> listarMascotasPorCliente(String clienteId){
        return mDao.findAll().stream().filter(m -> m.getClienteId().equals(clienteId)).collect(Collectors.toList());
    }
    }

