package com.gulukal.project.manyToManyFour;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	
	@ManyToMany  
	private List <Student> student =new ArrayList<>();

}
