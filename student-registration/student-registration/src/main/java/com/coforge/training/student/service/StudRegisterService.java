
package com.coforge.training.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coforge.training.student.model.Details;
import com.coforge.training.student.repository.StudRegisterRepository;

/*
*Author:Jeedipalli.Reddy
*Date:12 Dec 2024
*Time:3:49:53 pm
*Project:student-registration
*/

@Service
public class StudRegisterService {
    @Autowired
    private StudRegisterRepository detailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Details registerUser(Details details) {
    	details.setPassword(passwordEncoder.encode(details.getPassword()));
        return detailsRepository.save(details);
    }

    public Details findByEmail(String email) {
        return detailsRepository.findByEmail(email);
    }
    
    public boolean updatePassword(String email, String newPassword) {
        try {
            Details details = detailsRepository.findByEmail(email);
            if (details != null) {
                details.setPassword(passwordEncoder.encode(newPassword));
                detailsRepository.save(details);
                return true;
            }
            return false;
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error updating password: " + e.getMessage());
            return false;
        }
    }

    
//    public Details loginStudent(String email,String password) {
//    	// Find the user by email
//        Details details = detailsRepository.findByEmail(email);
//        
//        // Check if user exists and password matches
//        if (details != null && passwordEncoder.matches(password, details.getPassword())) {
//            return details;
//        } else {
//            throw new IllegalArgumentException("Invalid email or password");
//        }
//    }
    
}

