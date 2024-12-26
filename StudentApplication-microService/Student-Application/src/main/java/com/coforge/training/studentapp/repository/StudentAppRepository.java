
package com.coforge.training.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.studentapp.model.StudentApplication;

/*
*Author:Jeedipalli.Reddy
*Date:14 Dec 2024
*Time:12:28:18 pm
*Project:Student-Application
*/

public interface StudentAppRepository extends JpaRepository<StudentApplication, Long> {
	boolean existsByAadharNumber(String aadharNumber);

}
