package com.coforge.training.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/*
*Author:Jeedipalli.Reddy
*Date:12 Dec 2024
*Time:3:37:49 pm
*Project:student-registration
*/

@Entity
@Data
public class Address {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //addressId
   
    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false)
    private String district;
    
    @Column(nullable = false)
    private String houseNumber;
    
    @Column(nullable = false)
    private String street;
    
    @Column(nullable = false)
    private int pincode;
}

