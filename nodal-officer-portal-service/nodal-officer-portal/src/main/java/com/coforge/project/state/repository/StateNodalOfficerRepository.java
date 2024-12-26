package com.coforge.project.state.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.project.state.model.StateNodalOfficer;

/**
*Author:Koppula.Reddy
*date:Dec 13, 2024
*time:8:16:32 PM
*project:nodal-officer-portal

**/


public interface StateNodalOfficerRepository extends JpaRepository<StateNodalOfficer, Long> {
    StateNodalOfficer findByUsername(String username);
}

