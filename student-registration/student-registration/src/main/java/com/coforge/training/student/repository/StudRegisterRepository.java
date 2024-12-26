
package com.coforge.training.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.student.model.Details;

/*
*Author:Jeedipalli.Reddy
*Date:12 Dec 2024
*Time:3:41:59 pm
*Project:student-registration
*/

public interface StudRegisterRepository extends JpaRepository<Details, Long> {
	Details findByEmail(String email);
	
}



