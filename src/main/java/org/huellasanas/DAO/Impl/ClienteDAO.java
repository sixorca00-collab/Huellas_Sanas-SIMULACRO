package org.huellasanas.DAO.Impl;

import org.huellasanas.DAO.GenericDAO;
import org.huellasanas.models.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends GenericDAO<Cliente, String> {

    @Override
    protected Cliente mapToEntity(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getString("telefono"));
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO clientes (id, nombre, telefono) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE clientes SET nombre = ?, telefono = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM clientes WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT * FROM clientes WHERE id = ?";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT * FROM clientes";
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Cliente ent) throws SQLException {
        ps.setString(1, ent.getId());
        ps.setString(2, ent.getNombre());
        ps.setString(3, ent.getTelefono());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Cliente ent) throws SQLException {
        ps.setString(1, ent.getNombre());
        ps.setString(2, ent.getTelefono());
        ps.setString(3, ent.getId());
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

