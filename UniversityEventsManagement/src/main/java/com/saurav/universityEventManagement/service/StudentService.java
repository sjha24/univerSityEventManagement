package com.saurav.universityEventManagement.service;
import com.saurav.universityEventManagement.model.StudentDepartment;
import com.saurav.universityEventManagement.model.StudentModel;
import com.saurav.universityEventManagement.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;
    public String addStudent(StudentModel student) {
        if(student != null){
            studentRepo.save(student);
            return "Student added successfully";
        }
        return "Invalid data";
    }

    public List<StudentModel> getAllStudents() {
        return (List<StudentModel>) studentRepo.findAll();
    }
    public String updateByStudentIdAndStudentDepartment(Integer studentId, StudentDepartment studentDepartment) {
        Optional<StudentModel> Student = studentRepo.findById(studentId);
        StudentModel ourStudent = null;

        if(Student.isPresent()){
            ourStudent = Student.get();

        }else{
            return "Id is not found";
        }
        ourStudent.setStudentDepartment(studentDepartment);
        studentRepo.save(ourStudent);
        return "Student department updated successfully";
    }

    public Optional<StudentModel> getStudentById(Integer studentId) {
        return studentRepo.findById(studentId);
    }

    public String deleteStudentById(Integer studentId) {
        Optional<StudentModel> Student = studentRepo.findById(studentId);
        if(Student.isPresent()){
            studentRepo.deleteById(studentId);
            return "Student of this id "+studentId+" is removed successfully";
        }
        return "Student of this id "+studentId+" is not found in our database";
    }
}