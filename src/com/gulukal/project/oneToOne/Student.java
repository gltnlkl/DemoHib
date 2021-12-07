package com.gulukal.project.oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Student")
public class Student {
	
	
	@Id
	private int rollno;
	private String name;
	private int marks;
	
	
	@OneToOne   // one to one relation this anotation added laptop id as a foreign key
	private Laptop laptop;
	
	
	

}
