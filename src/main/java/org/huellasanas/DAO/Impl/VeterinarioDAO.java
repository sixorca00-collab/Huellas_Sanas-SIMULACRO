package org.huellasanas.DAO.Impl;

import org.huellasanas.DAO.GenericDAO;
import org.huellasanas.models.Veterinario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeterinarioDAO extends GenericDAO<Veterinario, String> {


    @Override
    protected Veterinario mapToEntity(ResultSet rs) throws SQLException {
        return  new Veterinario(
                rs.getString("id"),
                rs.getString("Nombre"),
                rs.getString("especialidad")
        );
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO veterinario (id, nombre, especialidad) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE veterinario SET nombre = ?, especialidad = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE * FORM veterinario WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT * FROM veterinario WHERE id = ?";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT * FROM veterinario";
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Veterinario ent) throws SQLException {
        ps.setString(1, ent.getId());
        ps.setString(2, ent.getNombre());
        ps.setString(3, ent.getEspecialidad());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Veterinario ent) throws SQLException {
        ps.setString(1, ent.getId());
        ps.setString(2, ent.getNombre());
        ps.setString(3, ent.getEspecialidad());

    }

    @Override
    protected void setDeleteParams(PreparedStatement ps, String id) throws SQLException {
        ps.setString(1, id);

    }

    @Override
    protected void setFindByIdParams(PreparedStatement ps, String id) throws SQLException {
    ps.setString(1, id);
    }
}
