package com.gulukal.project.embeded;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Embeddable  // diger tabloda gomulu 
public class AlienName {

	
	private String fname;
	private String lname;
	private String mname;
}
