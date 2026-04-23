package org.huellasanas.DAO.Impl;

import org.huellasanas.DAO.GenericDAO;
import org.huellasanas.models.Mascota;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MascotaDAO extends GenericDAO<Mascota, Integer> {

    @Override
    protected Mascota mapToEntity(ResultSet rs) throws SQLException {
        return new Mascota(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("genero"),
                rs.getString("tipo"),
                rs.getString("clienteId"));
    }


    @Override
    protected String getInsertQuery() {
        return "INSERT INTO mascotas (nombre, genero, tipo, clienteId) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE mascotas SET nombre = ?, genero = ?, tipo = ?, clienteId = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE * FROM mascotas WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT * FROM mascotas WHERE id = ? ";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT * FROM mascotas";
    }

    @Override
    protected void setDeleteParams(PreparedStatement ps, Integer id) throws SQLException {
        ps.setString(1, id.toString());

    }

    @Override
    protected void setFindByIdParams(PreparedStatement ps, Integer id) throws SQLException {
        ps.setString(1, id.toString());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Mascota ent) throws SQLException {
     ps.setInt(1, ent.getId());
     ps.setString(2, ent.getNombre());
     ps.setString(3, ent.getGenero());
     ps.setString(4, ent.getTipo());
     ps.setString(5, ent.getClienteId());
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Mascota ent) throws SQLException {
        ps.setInt(1, ent.getId());
        ps.setString(2, ent.getNombre());
        ps.setString(3, ent.getGenero());
        ps.setString(4, ent.getTipo());
        ps.setString(5, ent.getClienteId());

    }
}
