package com.coforge.project.institutes.controller;
 
 
import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.coforge.project.institutes.model.Institute;
import com.coforge.project.institutes.model.Student;
import com.coforge.project.institutes.repository.InstituteRepository;
import com.coforge.project.institutes.service.InstituteService;
import com.coforge.project.institutes.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
 
/**

*Author:Koppula.Reddy

*date:Dec 12, 2024

*time:9:07:05 PM

*project:institute
 
**/
 
 


@RestController

@RequestMapping("/api")

public class InstituteStudentController {

	   @Autowired

	    private StudentService studentService;

    @Autowired

    private InstituteService instituteService;


    @Autowired

    private InstituteRepository instituteRepository;
 
    @Autowired

    private PasswordEncoder passwordEncoder;
 
    // Register a new Institute

    @PostMapping("/institutes")

    public ResponseEntity<Institute> registerInstitute(

            @RequestPart("institute") String instituteJson,

            @RequestPart("proofInstitute") MultipartFile proofInstitute,

            @RequestPart("affiliatedDocument") MultipartFile affiliatedDocument) throws IOException {
 
        ObjectMapper objectMapper = new ObjectMapper();

        Institute institute = objectMapper.readValue(instituteJson, Institute.class);
 
        institute.setProofInstitute(proofInstitute.getBytes());

        institute.setAffiliatedDocument(affiliatedDocument.getBytes());

        Institute savedInstitute = instituteService.registerInstitute(institute);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedInstitute);

    }
 
 
    // Get all Institutes

    @GetMapping("/institutes")

    public List<Institute> getAllInstitutes() {

        return instituteService.getAllInstitutes();

    }
 
    // Get a specific Institute by ID

    @GetMapping("/institutes/{id}")

    public ResponseEntity<Institute> getInstituteById(@PathVariable Long id) {

        Institute institute = instituteService.getInstituteById(id);

        if (institute != null) {

            return ResponseEntity.ok(institute);

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

    }
 
    // Delete an Institute by ID

    @DeleteMapping("/institutes/{id}")

    public ResponseEntity<String> deleteInstitute(@PathVariable Long id) {

        instituteService.deleteInstitute(id);

        return ResponseEntity.ok("Institute deleted successfully!");

    }
 
    // Authenticate Institute login

    @PostMapping("/institutes/login")

    public ResponseEntity<String> authenticateInstitute(@RequestBody Institute loginRequest) {

        Institute institute = instituteRepository.findByCode(loginRequest.getCode());

        if (institute != null && passwordEncoder.matches(loginRequest.getPassword(), institute.getPassword())) {

            return ResponseEntity.ok("Login successful!");

        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");

        }

    }

    // ----- Student Endpoints -----

    @PostMapping("/students")

    public Student registerStudent(@RequestBody Student student) {

        return studentService.registerStudent(student);

    }

    @GetMapping("/students")

    public List<Student> getAllStudents() {

        return studentService.getAllStudents();

    }

    @GetMapping("/students/institute/{code}")

    public List<Student> getStudentsByInstitute(@PathVariable String code) {

        return studentService.getStudentsByInstituteCode(code);

    }

    @DeleteMapping("/students/{id}")

    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return "Student deleted successfully!";

    }
    @PostMapping("/institute/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        String newPassword = request.get("Password");
        boolean updated = instituteService.updatePassword(code, newPassword);
        if (updated) {
            return ResponseEntity.ok("Password updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("code not found!");
        }
    }


}

 