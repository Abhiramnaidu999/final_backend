package com.coforge.project.institutes.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.training.student.model.Details;

@FeignClient(name = "studentregistration-service")
public interface Studentclient {


	@GetMapping("/api/registration/user/{email}")
	    public ResponseEntity<Details> getUserByEmail(@PathVariable String email);
}
