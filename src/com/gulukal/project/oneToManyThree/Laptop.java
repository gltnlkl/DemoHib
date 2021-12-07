package com.gulukal.project.oneToManyThree;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="Laptop")
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	
	
//	@ManyToOne
//	private Student student;

}
