package com.greatLearning.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.lab5.entity.StudentDetails;
import com.greatLearning.lab5.service.StudentService;

@Controller
@RequestMapping("/studentData")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// add mapping for student list
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		System.out.println("Request Recieved");

		List<StudentDetails> theStudent = studentService.findAll();

		theModel.addAttribute("StudentDetails", theStudent);
		return "display-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		StudentDetails thestudent = new StudentDetails();
		theModel.addAttribute("StudentDetails", thestudent);
		return "registration-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		
		StudentDetails thestudent = studentService.findById(theId);
		
		theModel.addAttribute("StudentDetails", thestudent);
		
		return "registration-form";
	}

	@PostMapping("/save")
	public String saveDetails(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("department") String department,
			@RequestParam("country") String country) {

		System.out.println(id);
		StudentDetails thestudent;
		if (id != 0) {
			thestudent = studentService.findById(id);
			thestudent.setFirstName(firstName);
			thestudent.setLastName(lastName);
			thestudent.setDepartment(department);
			thestudent.setCountry(country);
		} else
			thestudent = new StudentDetails(firstName, lastName, department, country);
		studentService.save(thestudent);
		return "redirect:/studentData/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		studentService.deleteById(theId);

		return "redirect:/studentData/list";
	}
}
