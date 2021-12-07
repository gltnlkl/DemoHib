package com.gulukal.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gulukal.project.embeded.Alien;
import com.gulukal.project.embeded.AlienName;
import com.gulukal.project.oneToOne.Laptop;
import com.gulukal.project.oneToOne.Student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void manyToMany() {

		com.gulukal.project.manyToMany.Laptop laptop = new com.gulukal.project.manyToMany.Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		com.gulukal.project.manyToMany.Student student = new com.gulukal.project.manyToMany.Student();
		student.setRollno(1);
		student.setName("Gulten");
		student.setMarks(100);
		student.getLaptop().add(laptop);

		laptop.getStudent().add(student);

		Configuration con = new Configuration().configure()
				.addAnnotatedClass(com.gulukal.project.manyToMany.Student.class)
				.addAnnotatedClass(com.gulukal.project.manyToMany.Laptop.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		tx.commit();

		// output for student and laptop - existing fields as a column
		// and it has been created also 1 more mapping table which is true
		// three table has been created as a result

	}

	public static void manyToManyFourTable() {

		com.gulukal.project.manyToManyFour.Laptop laptop = new com.gulukal.project.manyToManyFour.Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		com.gulukal.project.manyToManyFour.Student student = new com.gulukal.project.manyToManyFour.Student();
		student.setRollno(1);
		student.setName("Gulten");
		student.setMarks(100);
		student.getLaptop().add(laptop);

		laptop.getStudent().add(student);

		Configuration con = new Configuration().configure()
				.addAnnotatedClass(com.gulukal.project.manyToManyFour.Student.class)
				.addAnnotatedClass(com.gulukal.project.manyToManyFour.Laptop.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		tx.commit();

		// output for student and laptop - existing fields as a column
		// but has been created also 2 more mapping table which is wrong

	}

	public static void oneToManyTwoTable() {

		com.gulukal.project.oneToManyTwo.Laptop laptop = new com.gulukal.project.oneToManyTwo.Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		com.gulukal.project.oneToManyTwo.Student student = new com.gulukal.project.oneToManyTwo.Student();
		student.setRollno(1);
		student.setName("Gulten");
		student.setMarks(100);
		student.getLaptop().add(laptop);

		laptop.setStudent(student);

		Configuration con = new Configuration().configure()
				.addAnnotatedClass(com.gulukal.project.oneToManyTwo.Student.class)
				.addAnnotatedClass(com.gulukal.project.oneToManyTwo.Laptop.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		tx.commit();

		// output for student - existing fields as a column
		// but in laptop table there is foreign key whic is come from student table , as
		// a result there will be two maps one of is has foreign key which class do not
		// have mappingBy anotation

	}

	public static void oneToManyThreeTable() {

		com.gulukal.project.oneToManyThree.Laptop laptop = new com.gulukal.project.oneToManyThree.Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		com.gulukal.project.oneToManyThree.Student student = new com.gulukal.project.oneToManyThree.Student();
		student.setRollno(1);
		student.setName("Gulten");
		student.setMarks(100);
		student.getLaptop().add(laptop);

		Configuration con = new Configuration().configure()
				.addAnnotatedClass(com.gulukal.project.oneToManyThree.Student.class)
				.addAnnotatedClass(com.gulukal.project.oneToManyThree.Laptop.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		tx.commit();

		// output for laptop and student - existing fields as a column
		// and also create one mapping table called student_laptop because we just put
		// anotation in to the student (one) class 
		// it is not correct solution

	}

	public static void oneToOne() {

		Laptop laptop = new Laptop(101, "Dell");

		Student student = new Student(001, "Gülten", 50, laptop);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		tx.commit();

		// output for laptop - existing fields as a column
		// for student - existing fields + foreign key from laptop

	}

	public static void save() {

		Alien telusko = new Alien(100, new AlienName("Gulten", "Ulukal", "Yonkuc"), "Blue");

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(telusko);

		tx.commit();

	}

	public static void fetch() {

		Alien telusko = new Alien();

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		telusko = (Alien) session.get(Alien.class, 101); // id si 101 olan Alien i getir db den

		tx.commit();

		System.out.println();

	}

	public static void main(String[] args) {
		
		manyToMany();
		//manyToManyFourTable();
		// oneToManyTwoTable();
		// oneToManyThreeTable();
		// oneToOne();
		// save();
		// fetch();

		launch(args);
	}

	@Override

	// javafx bilgileri burada bulunuyor
	public void start(Stage primaryStage) throws Exception {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Demo.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
