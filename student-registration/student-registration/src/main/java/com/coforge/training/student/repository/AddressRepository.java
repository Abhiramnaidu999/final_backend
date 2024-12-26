
package com.coforge.training.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.student.model.Address;

/*
*Author:Jeedipalli.Reddy
*Date:12 Dec 2024
*Time:3:44:07 pm
*Project:student-registration
*/

public interface AddressRepository extends JpaRepository<Address, Long> {
	
}