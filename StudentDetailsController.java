package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.StudentDetails;
import com.gl.service.StudentService;

@Controller
@RequestMapping("/studentdetails")
public class StudentDetailsController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudentDetails(Model theModel) {
		List<StudentDetails> sd = studentService.findAll();

		theModel.addAttribute("SD", sd);

		return "list-studentDetails";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data.
		StudentDetails sd = new StudentDetails();
		theModel.addAttribute("StudentDetail", sd);

		return "Detail-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the Book from the service
		StudentDetails sd = studentService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("StudentDetails", sd);

		// send over to our form
		return "Book-form";

	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int studentId, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println("Trying to save with Id :" + studentId);

		StudentDetails sd;
		if (studentId != 0) {
			// Update Operation
			sd = studentService.findById(studentId);

			// put updated values to the book object found from database.
			sd.setName(name);
			sd.setDepartment(department);
			sd.setCountry(country);

		} else {
			// Create Operation
			sd = new StudentDetails(name, department, country);
		}

		studentService.save(sd);
		return "redirect:/studentdetails/list";
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		// delete the book
		studentService.deleteById(theId);
		return "redirect:/studentdetails/list";
	}

}
