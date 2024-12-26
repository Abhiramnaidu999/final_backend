package com.coforge.project.institutes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.project.institutes.model.Institute;
import com.coforge.project.institutes.model.Student;
import com.coforge.project.institutes.repository.InstituteRepository;
import com.coforge.project.institutes.repository.StudentRepository;
/**
*Author:Koppula.Reddy
*date:Dec 12, 2024
*time:9:04:02 PM
*project:institute

**/



 
@Service
public class StudentService {
 
    @Autowired
    private StudentRepository studentRepository;
 
    @Autowired
    private InstituteRepository instituteRepository;
 
    public Student registerStudent(Student student) {
        // Validate and set the Institute entity
        Long instituteId = student.getInstitute().getId();
        Institute institute = instituteRepository.findById(instituteId)
                .orElseThrow(() -> new RuntimeException("Institute not found with ID: " + instituteId));
        student.setInstitute(institute);
 
        // Save the student
        return studentRepository.save(student);
    }
 
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
 
    public List<Student> getStudentsByInstituteCode(String code) {
        return studentRepository.findByInstitute_Code(code);
    }
 
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
 
