package com.saurav.universityEventManagement.repository;
import com.saurav.universityEventManagement.model.StudentDepartment;
import com.saurav.universityEventManagement.model.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<StudentModel,Integer> {
}
