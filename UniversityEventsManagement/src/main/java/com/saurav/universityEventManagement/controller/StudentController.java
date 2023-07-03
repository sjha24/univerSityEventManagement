package com.saurav.universityEventManagement.controller;

import com.saurav.universityEventManagement.model.StudentDepartment;
import com.saurav.universityEventManagement.model.StudentModel;
import com.saurav.universityEventManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("SC")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/student")
    public String addStudent(@RequestBody StudentModel student){
        return studentService.addStudent(student);
    }
    @GetMapping("/students")
    public List<StudentModel>getAllStudents(){
        return studentService.getAllStudents();
    }
    @PutMapping("/student/{studentId}/{studentDepartment}")
    public String updateByStudentIdAndStudentDepartment(@PathVariable Integer studentId, @PathVariable StudentDepartment studentDepartment){
        return studentService.updateByStudentIdAndStudentDepartment(studentId,studentDepartment);
    }
    @GetMapping("/student/{studentId}")
    public Optional<StudentModel> getStudentById(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }
    @DeleteMapping("/student/{studentId}")
    public String deleteStudentById(@PathVariable Integer studentId){
        return studentService.deleteStudentById(studentId);
    }
}
