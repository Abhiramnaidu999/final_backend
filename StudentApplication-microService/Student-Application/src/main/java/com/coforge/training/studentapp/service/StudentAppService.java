
package com.coforge.training.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.studentapp.model.StudentApplication;
import com.coforge.training.studentapp.repository.StudentAppRepository;

import jakarta.transaction.Transactional;

/*
*Author:Jeedipalli.Reddy
*Date:14 Dec 2024
*Time:12:29:05 pm
*Project:Student-Application
*/

@Service
public class StudentAppService {

    @Autowired
    private StudentAppRepository studentApplicationRepository;
    
    public boolean isDuplicateAadharNumber(String aadharNumber) {
        return studentApplicationRepository.existsByAadharNumber(aadharNumber);
    }

    @Transactional
    public StudentApplication saveStudentApplication(StudentApplication studentApplication) {
        return studentApplicationRepository.save(studentApplication);
    }

    public List<StudentApplication> getAllStudentApplications() {
        return studentApplicationRepository.findAll();
    }

    public Optional<StudentApplication> getStudentApplicationById(Long id) {
        return studentApplicationRepository.findById(id);
    }

    @Transactional
    public void deleteStudentApplication(Long id) {
        studentApplicationRepository.deleteById(id);
    }
    
   

}
