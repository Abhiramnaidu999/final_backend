
package com.coforge.training.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coforge.training.student.model.Details;
import com.coforge.training.student.repository.StudRegisterRepository;

/*
*Author:Jeedipalli.Reddy
*Date:13 Dec 2024
*Time:12:01:06 pm
*Project:student-registration
*/

@Service
public class AuthenticationService {
	@Autowired
	private StudRegisterRepository detailsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean authenticate(String email, String rawPassword) {
	    Details details = detailsRepository.findByEmail(email);
	    if (details != null) {
	        return passwordEncoder.matches(rawPassword, details.getPassword());
	    }
	    return false;
 
}
}