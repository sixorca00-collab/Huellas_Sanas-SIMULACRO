package org.huellasanas.DAO;
import java.util.List;
import java.util.Optional;

public interface PatronDAO<E, ID> {
    boolean save(E entidad);
    boolean update(E entidad);
    boolean delete(E entidad);
    Optional<E> findById(ID id);
    List<E> findAll();

}
