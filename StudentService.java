package com.gl.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gl.model.StudentDetails;

@Service
public interface StudentService {

	List<StudentDetails> findAll();

	void save(StudentDetails mystudentdetails);
	
	StudentDetails findById(int studentId);

	void deleteById(int studentId);

	void print(List<StudentDetails> studentdetails);

}
