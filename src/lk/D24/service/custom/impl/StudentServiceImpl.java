package lk.D24.service.custom.impl;

import lk.D24.dto.StudentDTO;
import lk.D24.repository.RepositoryFactory;
import lk.D24.repository.RepositoryType;
import lk.D24.repository.custom.StudentRepository;
import lk.D24.service.custom.StudentService;
import lk.D24.service.util.Convertor;
import lk.D24.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentServiceImpl implements StudentService {

   private final StudentRepository studentRepository;
   private final Convertor convertor;

   public StudentServiceImpl(){
       studentRepository = RepositoryFactory.getInstance().getRepository(RepositoryType.STUDENT);
       convertor= new Convertor();
   }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (studentRepository.save(session, convertor.toStudent(studentDTO)) == null)
                throw new RuntimeException("Failed to save student");
            transaction.commit();
            session.close();
            return studentDTO;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(StudentDTO studentDTO) {

    }

    @Override
    public String getNextPk() {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        return null;
    }

    @Override
    public StudentDTO getStudentByPk(String pk) {
        return null;
    }
}
