package com.coforge.project.institutes.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
*Author:Koppula.Reddy
*date:Dec 12, 2024
*time:8:54:56 PM
*project:institute

**/
@Entity
@Table(name = "institutes")
public class Institute {
	
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column( nullable = false)
	    private String name;
	 
	    @Column( nullable = false)
	    private String code;
	    private String state;
	    private String location;
	    private String district;
	    private String diseCode;
	    private String instituteType;
	    private String affiliatedBy;
	    private int yearStarted;
	    private String password;
	    private String confirmPassword;
	    private String affiliatedUniversity;
	    
	    @Lob
	    @JsonIgnore
	    private byte[] proofInstitute;
	    
	    @Lob
	    @JsonIgnore
	    private byte[] affiliatedDocument;
	    
	    private String affiliatedTo;
	    private String address;
	    private String principalName;
	    private String mobileNumber;
	    private String telephone;

	    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference // Prevents infinite loop
	    @JsonIgnore
	    private List<Student> students = new ArrayList<>();

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

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getDiseCode() {
			return diseCode;
		}

		public void setDiseCode(String diseCode) {
			this.diseCode = diseCode;
		}

		public String getInstituteType() {
			return instituteType;
		}

		public void setInstituteType(String instituteType) {
			this.instituteType = instituteType;
		}

		public String getAffiliatedBy() {
			return affiliatedBy;
		}

		public void setAffiliatedBy(String affiliatedBy) {
			this.affiliatedBy = affiliatedBy;
		}

		public int getYearStarted() {
			return yearStarted;
		}

		public void setYearStarted(int yearStarted) {
			this.yearStarted = yearStarted;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public String getAffiliatedUniversity() {
			return affiliatedUniversity;
		}

		public void setAffiliatedUniversity(String affiliatedUniversity) {
			this.affiliatedUniversity = affiliatedUniversity;
		}

		public byte[] getProofInstitute() {
			return proofInstitute;
		}

		public void setProofInstitute(byte[] proofInstitute) {
			this.proofInstitute = proofInstitute;
		}

		public byte[] getAffiliatedDocument() {
			return affiliatedDocument;
		}

		public void setAffiliatedDocument(byte[] affiliatedDocument) {
			this.affiliatedDocument = affiliatedDocument;
		}

		public String getAffiliatedTo() {
			return affiliatedTo;
		}

		public void setAffiliatedTo(String affiliatedTo) {
			this.affiliatedTo = affiliatedTo;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPrincipalName() {
			return principalName;
		}

		public void setPrincipalName(String principalName) {
			this.principalName = principalName;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}

		


	
	}
	 


