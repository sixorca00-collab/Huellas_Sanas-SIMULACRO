package org.huellasanas.DAO;

import org.huellasanas.config.DbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAO<E, ID> implements PatronDAO<E, ID> {

    protected Connection getConnection() {
        return DbConfig.getConnection();
    }

    //  mapping
    protected abstract E mapToEntity(ResultSet rs) throws SQLException;

    //  SQL
    protected abstract String getInsertQuery();
    protected abstract String getUpdateQuery();
    protected abstract String getDeleteQuery();
    protected abstract String getFindByIdQuery();
    protected abstract String getFindAllQuery();

    // params
    protected abstract void setInsertParams(PreparedStatement ps, E ent) throws SQLException;
    protected abstract void setUpdateParams(PreparedStatement ps, E ent) throws SQLException;
    protected abstract void setDeleteParams(PreparedStatement ps, ID id) throws SQLException;
    protected abstract void setFindByIdParams(PreparedStatement ps, ID id) throws SQLException;

//Aca toda la ejecución- por eso va en GenericDAO
    @Override
    public boolean save(E ent) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(getInsertQuery())) {

            setInsertParams(ps, ent);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(E ent) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(getUpdateQuery())) {

            setUpdateParams(ps, ent);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(ID id) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(getDeleteQuery())) {

            setDeleteParams(ps, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<E> findById(ID id) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(getFindByIdQuery())) {

            setFindByIdParams(ps, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToEntity(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<E> findAll() {
        List<E> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(getFindAllQuery());
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapToEntity(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}