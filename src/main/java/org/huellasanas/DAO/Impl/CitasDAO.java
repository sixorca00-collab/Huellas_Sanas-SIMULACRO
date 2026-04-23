package org.huellasanas.DAO.Impl;

import org.huellasanas.DAO.GenericDAO;
import org.huellasanas.models.Cita;
import org.huellasanas.models.Veterinario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitasDAO extends GenericDAO<Cita, Integer> {
    @Override
    protected Cita mapToEntity(ResultSet rs) throws SQLException {
        return new Cita(
                rs.getInt("id"),
                rs.getString("fecha"),
                rs.getString("hora"),
                rs.getInt("mascotaId"),
                rs.getString("veterinarioId"),
                rs.getString("motivo")
        );
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO cita (id, fecha, hora, mascotaId, veterinarioId, motivo) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE cita SET fecha = ?, hora = ?, mascotaId = ?, veterinarioId = ?, motivo = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE * FROM cita WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT * FROM cita WHERE id = ? ";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT * FROM cita";
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Cita ent) throws SQLException {
        ps.setInt(1, ent.getId());
        ps.setString(2, ent.getFecha());
        ps.setString(3, ent.getHora());
        ps.setInt(4, ent.getMascotaId());
        ps.setString(5, ent.getVeterinarioId());
        ps.setString(6, ent.getMotivo());

    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Cita ent) throws SQLException {
        ps.setString(1, ent.getFecha());
        ps.setString(2, ent.getHora());
        ps.setInt(3, ent.getMascotaId());
        ps.setString(4, ent.getVeterinarioId());
        ps.setString(5, ent.getMotivo());
        ps.setInt(6, ent.getId());

    }

    @Override
    protected void setDeleteParams(PreparedStatement ps, Integer id) throws SQLException {
        ps.setInt(1, id);

    }

    @Override
    protected void setFindByIdParams(PreparedStatement ps, Integer id) throws SQLException {
        ps.setInt(1, id);

    }
}
