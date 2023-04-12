package lk.D24.repository.custom.impl;

import lk.D24.entity.Student;
import lk.D24.repository.custom.StudentRepository;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public Student save(Session session, Student student) {
        try{
            session.save(student);
            return student;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student update(Session session, Student student) {
        try {
            session.update(student);
            return student;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Session session, Student student) {
        try {
            session.delete(student);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll(Session session) {
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> rootEntry = cq.from(Student.class);
            CriteriaQuery<Student> all = cq.select(rootEntry);

            TypedQuery<Student> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student get(Session session, String pk) {

        try {
            return session.get(Student.class, pk);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
