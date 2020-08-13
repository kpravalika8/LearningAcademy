package com.dxc.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String classname;
	@OneToMany(mappedBy="class",cascade=CascadeType.ALL)
	private List<Subject> subject=new ArrayList<>();
	@OneToMany(mappedBy="class",cascade=CascadeType.ALL)
	private List<Student> student=new ArrayList<>(); 
	@OneToMany(mappedBy="class",cascade=CascadeType.ALL)
	private List<Teacher> teacher=new ArrayList<>(); 
	
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class(String classname) {
		super();
		this.classname = classname;
	}
	public Class(int id, String classname) {
		super();
		this.id = id;
		this.classname = classname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public List<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", classname=" + classname + ", subject=" + subject + ", student=" + student
				+ ", teacher=" + teacher + "]";
	}
	
	
	
	

}
