package com.greatLearning.lab5.service;

import java.util.List;

import com.greatLearning.lab5.entity.StudentDetails;

public interface StudentService {
	//declare curd operations
	
	public List<StudentDetails> findAll();
	public StudentDetails findById(int theId);
	public void save(StudentDetails theStudent);
	public void deleteById(int theId);
}
