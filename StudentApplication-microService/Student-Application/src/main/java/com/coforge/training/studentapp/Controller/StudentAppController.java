package com.coforge.training.studentapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.studentapp.model.StudentApplication;
import com.coforge.training.studentapp.service.StudentAppService;

/*
*Author: Jeedipalli.Reddy
*Date: 14 Dec 2024
*Time: 12:31:34 pm
*Project: Student-Application
*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/student-applications")
public class StudentAppController {

    @Autowired
    private StudentAppService studentApplicationService;

    @PostMapping("/save")
    public ResponseEntity<StudentApplication> createStudentApplication(@RequestBody StudentApplication studentApplication) {
        try {
            StudentApplication savedApplication = studentApplicationService.saveStudentApplication(studentApplication);
            return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/display")
    public ResponseEntity<List<StudentApplication>> getAllStudentApplications() {
        try {
            List<StudentApplication> applications = studentApplicationService.getAllStudentApplications();
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<StudentApplication> getStudentApplicationById(@PathVariable Long id) {
        Optional<StudentApplication> application = studentApplicationService.getStudentApplicationById(id);
        return application.map(app -> new ResponseEntity<>(app, HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentApplication> updateStudentApplication(@PathVariable Long id, @RequestBody StudentApplication studentApplication) {
        Optional<StudentApplication> existingApplication = studentApplicationService.getStudentApplicationById(id);
        if (existingApplication.isPresent()) {
            studentApplication.setApplicatinId(id);
            StudentApplication updatedApplication = studentApplicationService.saveStudentApplication(studentApplication);
            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudentApplication(@PathVariable Long id) {
        try {
            Optional<StudentApplication> application = studentApplicationService.getStudentApplicationById(id);
            if (application.isPresent()) {
                studentApplicationService.deleteStudentApplication(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/check-duplicate/{aadharNumber}")
    public ResponseEntity<Boolean> checkDuplicate(@PathVariable String aadharNumber) {
        boolean isDuplicate = studentApplicationService.isDuplicateAadharNumber(aadharNumber);
        return new ResponseEntity<>(isDuplicate, HttpStatus.OK);
    }
}
