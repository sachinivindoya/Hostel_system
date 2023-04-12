package lk.D24.service.util;

import lk.D24.dto.StudentDTO;
import lk.D24.entity.Student;

import java.util.ArrayList;

public class Convertor {
    public Student toStudent(StudentDTO studentDTO){
        return new Student(studentDTO.getStudentID(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getDoB(),studentDTO.getGender());
    }
    public StudentDTO forStudent(Student student){
        return new StudentDTO(student.getStudentID(), student.getName(), student.getAddress(), student.getContact(),student.getDoB(),student.getGender());
    }

}

