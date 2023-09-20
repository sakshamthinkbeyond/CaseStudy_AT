package com.training.courseservice.model;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Entity

public class Student {
	
		//@Id
		//@GeneratedValue(strategy=GenerationType.AUTO)
		private long studId;
		private String studName;
		private int age;
		//@Column(name="stud_grade")
		private String grade;
		
		public Student(String studName,int age,String grade)
		{
			super();
			this.studName=studName;
			this.age=age;
			this.grade=grade;
		}
		
}
