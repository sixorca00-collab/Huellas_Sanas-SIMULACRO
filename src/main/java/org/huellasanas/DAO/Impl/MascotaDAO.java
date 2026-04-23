package org.huellasanas.DAO.Impl;

import org.huellasanas.DAO.GenericDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MascotaDAO<Mascota > extends GenericDAO {
    @Override
    protected Object mapToEntity(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected String getInsertQuery() {
        return "";
    }

    @Override
    protected String getUpdateQuery() {
        return "";
    }

    @Override
    protected String getDeleteQuery() {
        return "";
    }

    @Override
    protected String getFindByIdQuery() {
        return "";
    }

    @Override
    protected String getFindAllQuery() {
        return "";
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Object ent) throws SQLException {

    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Object ent) throws SQLException {

    }


    @Override
    protected void setDeleteParams(PreparedStatement ps, Object o) throws SQLException {

    }


    @Override
    protected void setFindByIdParams(PreparedStatement ps, Object o) throws SQLException {

    }

    @Override
    public boolean save(Object entidad) {
        return false;
    }

    @Override
    public boolean update(Object entidad) {
        return false;
    }

    @Override
    public boolean delete(Object entidad) {
        return false;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return List.of();
    }
}
