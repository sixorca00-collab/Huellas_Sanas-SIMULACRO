package org.huellasanas.DAO;
import org.huellasanas.config.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO<E, ID> implements PatronDAO<E, ID> {

    protected Connection getConnection() {
        return DbConfig.getConnection();
    }
    //instanciar resultSet
    protected abstract E mapToEntity(ResultSet rs) throws SQLException;
    //Consultas SQL
    protected abstract String getInsertQuery();
    protected abstract String getUpdateQuery();
    protected abstract String getDeleteQuery();
    protected abstract String getFindByIdQuery();
    protected abstract String getFindAllQuery();

    //Parametros preparados
    protected abstract void setInsertParams(PreparedStatement ps, E ent) throws SQLException;
    protected abstract void setUpdateParams(PreparedStatement ps, E ent) throws SQLException;
    protected abstract void setDeleteParams(PreparedStatement ps, ID id) throws SQLException;
    protected abstract void setFindByIdParams(PreparedStatement ps, ID id) throws SQLException;





}
