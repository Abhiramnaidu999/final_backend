
package com.coforge.training.studentapp.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/*
*Author:Jeedipalli.Reddy
*Date:14 Dec 2024
*Time:12:16:32 pm
*Project:Student-Application
*/

@Entity
@Data
public class StudentApplication {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicatinId;

    @Column(nullable = false, unique = true)
    private String aadharNumber;

    @Column(nullable = false)
    private String instituteCode;

    @Column(nullable = false)
    private String instituteName;

    @Column(nullable = false)
    private String presentCourse;

    @Column(nullable = false)
    private int presentCourseYear;

    @Column(nullable = false)
    private String modeOfStudy;

    @Column(nullable = false)
    private Date classStartDate;

    @Column(nullable = false)
    private String universityName;

    @Column(nullable = false)
    private double tuitionFee;

    @Column(nullable = false)
    private String scheme;
}
