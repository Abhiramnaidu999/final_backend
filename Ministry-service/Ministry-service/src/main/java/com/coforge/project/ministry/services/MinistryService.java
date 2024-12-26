package com.coforge.project.ministry.services;

/**
*Author:Koppula.Reddy
*date:Dec 14, 2024
*time:12:08:36 PM
*project:Ministry-service

**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coforge.project.ministry.model.Ministry;
import com.coforge.project.ministry.repository.MinistryRepository;


@Service
public class MinistryService {

    @Autowired
    private MinistryRepository ministryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Ministry registerMinistry(Ministry ministry) {
        String encodedPassword = passwordEncoder.encode(ministry.getPassword());
        ministry.setPassword(encodedPassword);
        return ministryRepository.save(ministry);
    }

    public Ministry authenticate(String email, String rawPassword) {
        Ministry ministry = ministryRepository.findByEmail(email);
        if (ministry != null && passwordEncoder.matches(rawPassword, ministry.getPassword())) {
            return ministry;
        }
        return null;
    }
    
    public boolean updatePassword(String email, String newPassword) {
        Ministry officer = ministryRepository.findByEmail(email);
        if (officer != null) {
            officer.setPassword(passwordEncoder.encode(newPassword));
           ministryRepository.save(officer);
            return true;
        }
        return false;
    }



}
