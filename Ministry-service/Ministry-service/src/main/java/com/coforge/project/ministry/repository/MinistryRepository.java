package com.coforge.project.ministry.repository;

/**
*Author:Koppula.Reddy
*date:Dec 14, 2024
*time:12:07:15 PM
*project:Ministry-service

**/
import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.project.ministry.model.Ministry;

public interface MinistryRepository extends JpaRepository<Ministry, Long> {
    Ministry findByEmail(String email);
    
 



}

