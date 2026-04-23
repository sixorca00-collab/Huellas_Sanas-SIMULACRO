package org.huellasanas.DAO.Impl;

import org.huellasanas.DAO.GenericDAO;
import org.huellasanas.models.Cita;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CitasDAO extends GenericDAO<Cita, Integer> {

    @Override
    protected Cita mapToEntity(ResultSet rs) throws SQLException {

        LocalDateTime fechaHora = LocalDateTime.of(
                LocalDate.parse(rs.getString("fecha")),
                LocalTime.parse(rs.getString("hora"))
        );

        return new Cita(
                rs.getInt("id"),
                fechaHora,
                rs.getInt("mascota_id"),
                rs.getString("veterinario_id"),
                rs.getString("motivo")
        );
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO cita (fecha, hora, mascota_id, veterinario_id, motivo) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE cita SET fecha = ?, hora = ?, mascota_id = ?, veterinario_id = ?, motivo = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM cita WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT * FROM cita WHERE id = ?";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT * FROM cita";
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Cita ent) throws SQLException {

        ps.setString(1, ent.getFechaHora().toLocalDate().toString());
        ps.setString(2, ent.getFechaHora().toLocalTime().toString());
        ps.setInt(3, ent.getMascotaId());
        ps.setString(4, ent.getVeterinarioId());
        ps.setString(5, ent.getMotivo());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Cita ent) throws SQLException {

        ps.setString(1, ent.getFechaHora().toLocalDate().toString());
        ps.setString(2, ent.getFechaHora().toLocalTime().toString());
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