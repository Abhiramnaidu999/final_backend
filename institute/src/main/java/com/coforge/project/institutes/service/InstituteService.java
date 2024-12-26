package com.coforge.project.institutes.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coforge.project.institutes.model.Institute;
import com.coforge.project.institutes.repository.InstituteRepository;

/**
*Author:Koppula.Reddy
*date:Dec 12, 2024
*time:9:02:23 PM
*project:institute

**/


 
@Service
public class InstituteService {
 

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new Institute
    public Institute registerInstitute(Institute institute) {
        String encodedPassword = passwordEncoder.encode(institute.getPassword());
        institute.setPassword(encodedPassword);
        institute.setConfirmPassword(encodedPassword); // Ensure confirmPassword is also encoded
        return instituteRepository.save(institute);
    }

    // Get all Institutes
    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    // Get a specific Institute by ID
    public Institute getInstituteById(Long id) {
        return instituteRepository.findById(id).orElse(null);
    }

    // Delete an Institute by ID
    public void deleteInstitute(Long id) {
        instituteRepository.deleteById(id);
    }
    public boolean updatePassword(String code, String newPassword) {
        Institute institute = instituteRepository.findByCode(code);
        if (institute != null) {
        	institute.setPassword(passwordEncoder.encode(newPassword));
        	instituteRepository.save(institute);
            return true;
        }
        return false;
    }
}
 