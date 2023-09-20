package com.training.courseservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.courseservice.intercomm.StudentClient;
import com.training.courseservice.model.Course;
import com.training.courseservice.model.Student;
import com.training.courseservice.repository.CourseRepository;


@RestController
@RequestMapping("/courapi")
public class CourseController {
		
	@Autowired
	CourseRepository repository;
	
		//@GetMapping("/cour")
		
//		public List<Course> getCour()
//		{
//			List<Student> studList= new ArrayList<>();
//			studList.add(new Student("Raj", 21,"A+"));
//			studList.add(new Student("Roy",21,"A+"));
//			studList.add(new Student("Ajay", 23,"B+"));
//			studList.add(new Student("Abhay",22,"A+"));
//			studList.add(new Student("Akash",24,"C+"));
//			return studList;
//			
//			return repository.findAll();
//			
//		}
//		
		@Autowired
		StudentClient studClient;
		
		@GetMapping("/course")
		public ResponseEntity<List<Course>>getCourse()
		{
			List<Course> courseList=repository.findAll();
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		
		@PostMapping("/post")
		public ResponseEntity<Course> addCourse(@RequestBody Course course)
		{
			return new ResponseEntity<Course>(repository.save(course),HttpStatus.CREATED);
		}
		
		@GetMapping("/service/stud/{studId}")
		public Student getStud(@PathVariable int studId)
		{
		
			return studClient.getStudent(studId);
		}
		
//		{
//		List<Course> courseList=repository.findAll();
//		return new ResponseEntity<>(courseList,HttpStatus.OK);
//		}
		
		//@ResponseBody
//		public String getStud()
//		{
//			return "Hi There!";
//		}
//	
		
		@GetMapping("/cour/{id}")
		public Course getCourById(@PathVariable("id") long id)
		{
			Optional<Course> cour=repository.findById(id);
			
			if(cour.isPresent())
			{
				return cour.get();
			}
			else {
				return null;
			}
		}


		@PutMapping("/cour/{id}")
		public void updateUser(@PathVariable("id") long id,@RequestBody Course cour)
		{
			
			Optional<Course> oldData=repository.findById(id);
			if(oldData.isPresent())
			{
				Course std=oldData.get();
				std.setCredits(cour.getCredits());
				std.setGrade(cour.getGrade());
				std.setCourName(cour.getCourName());
				repository.save(std);
			}
		}
		
		@DeleteMapping("/cour/{id}")
		public void deleteUser(@PathVariable("id") long id)
		{
			Optional<Course> cour= repository.findById(id);
			if(cour.isPresent())
			{
				repository.delete(cour.get());
			}
			else {
				return;
			}
		}
}
