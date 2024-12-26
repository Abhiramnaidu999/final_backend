package com.coforge.project.state.service;

/**
*Author:Koppula.Reddy
*date:Dec 13, 2024
*time:8:18:44 PM
*project:nodal-officer-portal

**/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coforge.project.state.model.StateNodalOfficer;
import com.coforge.project.state.repository.StateNodalOfficerRepository;

@Service
public class StateNodalOfficerService {

    @Autowired
    private StateNodalOfficerRepository stateNodalOfficerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public StateNodalOfficer registerOfficer(StateNodalOfficer officer) {
        officer.setPassword(passwordEncoder.encode(officer.getPassword()));
        return stateNodalOfficerRepository.save(officer);
    }

    public boolean authenticate(String username, String rawPassword) {
        StateNodalOfficer officer = stateNodalOfficerRepository.findByUsername(username);
        return officer != null && passwordEncoder.matches(rawPassword, officer.getPassword());
    }
    public boolean updatePassword(String username, String newPassword) {
        StateNodalOfficer officer = stateNodalOfficerRepository.findByUsername(username);
        if (officer != null) {
            officer.setPassword(passwordEncoder.encode(newPassword));
            stateNodalOfficerRepository.save(officer);
            return true;
        }
        return false;
    }
}

