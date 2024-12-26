package com.coforge.project.institutes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
*Author:Koppula.Reddy
*date:Dec 12, 2024
*time:8:57:12 PM
*project:institute

**/
@Entity
@Table(name = "students")
public class Student {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column(nullable = false)
	    private String name;
	 
	    @Column(nullable = false, unique = true)
	    private String email;
	 
	    @Column(nullable = false)
	    private String course;
	 
	    @Column(nullable = false, unique = true)
	    private String aadharNumber;
	 
	    @ManyToOne
	    @JoinColumn(name = "institute_id", nullable = false)
	    @JsonBackReference // Prevents infinite loop
	    private Institute institute;
	 
	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getCourse() {
	        return course;
	    }
	 
	    public void setCourse(String course) {
	        this.course = course;
	    }
	 
	    public String getAadharNumber() {
	        return aadharNumber;
	    }
	 
	    public void setAadharNumber(String aadharNumber) {
	        this.aadharNumber = aadharNumber;
	    }
	 
	    public Institute getInstitute() {
	        return institute;
	    }
	 
	    public void setInstitute(Institute institute) {
	        this.institute = institute;
	    }
	}
	 


