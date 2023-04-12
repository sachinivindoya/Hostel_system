package lk.D24.service.custom;

import lk.D24.dto.StudentDTO;
import lk.D24.service.SuperService;

import java.util.List;

public interface StudentService extends SuperService {


    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO);

    void deleteStudent(StudentDTO studentDTO);

    String getNextPk();

    List<StudentDTO> getAllStudent();

    StudentDTO getStudentByPk(String pk);

}
