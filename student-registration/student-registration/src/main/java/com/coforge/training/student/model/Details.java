
package com.coforge.training.student.model;

import java.sql.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
*Author:Jeedipalli.Reddy
*Date:12 Dec 2024
*Time:2:49:14 pm
*Project:student-service
*/

@Entity
@Data
public class Details {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;
	
	@Column(name="first_name",nullable = false)
    private String firstName; // divide firstName,lastName
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name="DOB",nullable = false)
    private Date dob;
	
	@Column(nullable = false)
    private String gender;
	
	@Column(nullable = false)
    private Long contact;
	
	@Column(nullable = false)
    private String email;
	
	@Column(nullable = false)
    private String instCode;
	
	@Column(nullable = false,unique = true)
    private long accNum;
	
	@Column(nullable = false,unique = true)
    private long adhar;
	
	@Column(nullable = false)
    private String ifsc;
	
	@Column(nullable = false)
    private String bankName;
	
	@NotBlank(message="Password cannot be blank")
	@Size(min=8,max=255,message="Password must be between 8 and 255 characters")
	@Column(name = "password",nullable = false)
    private String password;
	
	@Column(nullable = false)
    private String ;
	
	@Column(nullable = false)
    private String fatherName;
	@Column(nullable = false)
    private String motherName;
	@Column(nullable = false,unique = true)
    private int sscNumber;
	@Column(nullable = false)
    private String sscboardName;
	@Column(nullable = false)
    private int sscpassingyear;
	@Column(nullable = false)
    private float sscMarks;
    @Column(nullable = false,unique = true)
    private int interNumber;
    @Column(nullable = false)
    private String interboardName;
    @Column(nullable = false)
    private int interpassingyear;
    @Column(nullable = false)
    private float interMarks;
    @Column(nullable = false)
    private boolean disabled;
    @Column(nullable = false)
    private String disabilityType;
    @Column(nullable = false)
    private String maritalStatus;
    @Column(nullable = false)
    private String fatherprofession;
    
    @Lob
    private byte[] Aadhar;
    @Lob
    private byte[] photograph;
    @Lob
    private byte[] idCard;
    @Lob
    private byte[] casteCertificate;
    @Lob
    private byte[] incomeCertificate;
    @Lob
    private byte[] Bankpassbook;
    @Lob
    private byte[] SSCmarksheet;
    @Lob
    private byte[] Intermediatemarksheet;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}

