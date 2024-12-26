package com.coforge.project.institutes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.project.institutes.model.Student;

/**
*Author:Koppula.Reddy
*date:Dec 12, 2024
*time:9:01:07 PM
*project:institute

**/
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByInstituteId(Long instituteId);

	List<Student> findByInstitute_Code(String code);

}
