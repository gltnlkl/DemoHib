package com.gulukal.project.embeded;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gulukal.project.oneToOne.Laptop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "gulten") // table name
public class Alien {

	@Id
	private int aid;
//	@Column(name = "name") // column name
	private AlienName aname;
// @Transient // this column will be not shown in database
	private String acolor;

}
