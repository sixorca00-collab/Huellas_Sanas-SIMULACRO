package org.huellasanas.services;

import org.huellasanas.DAO.Impl.ClienteDAO;
import org.huellasanas.models.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final ClienteDAO cDAO = new ClienteDAO();

    public boolean crearCliente(Cliente c){
        if (c == null) return false;
        return cDAO.save(c);
    }

    //Listar
    public List<Cliente> listarClientes(){
        return cDAO.findAll();
    }

    //Por id
    public Optional<Cliente> buscarClientePorId(String id){
        return cDAO.findById(id);
    }

    //Actualizar
    public boolean actualizarCliente(Cliente c){
        if (c == null) return false;
        return cDAO.update(c);
    }

    //Eliminar
    public boolean eliminarCliente(String id){
        return cDAO.delete(id);
    }
}
