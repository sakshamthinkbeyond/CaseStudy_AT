package com.training.courseservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity

public class Course {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long courId;
		private String courName;
		private int credits ;
		@Column(name="cour_grade")
		private String grade;
		
		public Course(String courName,int credits,String grade)
		{
			super();
			this.courName=courName;
			this.credits=credits;
			this.grade=grade;
		}
		
}
