package com.coforge.project.institutes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.project.institutes.model.Institute;

/**
*Author:Koppula.Reddy
*date:Dec 12, 2024
*time:9:00:11 PM
*project:institute

**/
public interface InstituteRepository extends JpaRepository<Institute, Long>{
	 Institute findByCode(String code);

}
