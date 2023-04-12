package lk.D24.repository;

import lk.D24.entity.SuperEntity;
import org.hibernate.Session;

import java.util.List;

public interface CrudRepository <T extends SuperEntity> extends SuperRepository {
    T save(Session session, T entity) ;

    T update(Session session, T entity) ;

    void delete(Session session, T entity) ;

    List<T> findAll(Session session);

    T get(Session session, String pk);
}
