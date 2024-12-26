package com.coforge.project.institutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coforge.project.institutes.model.Institute;
import com.coforge.project.institutes.repository.InstituteRepository;

/**
*Author:Koppula.Reddy
*date:Dec 13, 2024
*time:11:25:29 AM
*project:institute-1

**/
@Service
public class AuthenticationService {
	@Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String code, String rawPassword) {
        Institute institute = instituteRepository.findByCode(code);
        if (institute != null) {
            return passwordEncoder.matches(rawPassword, institute.getPassword());
        }
        return false;
    }

}
