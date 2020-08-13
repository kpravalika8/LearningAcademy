package com.dxc.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Student")
public class Student {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			@Column(name = "name")
			private String name;
			@Column(name = "email")
			private String email;
			@Column(name = "country")
			private String country;
			@ManyToMany(mappedBy="student",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER )
			private Set<Teacher> teachers=new HashSet<>();

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getCountry() {
				return country;
			}

			public void setCountry(String country) {
				this.country = country;
			}

			public Set<Teacher> getTeachers() {
				return teachers;
			}

			public void addTeacher(Teacher teacher) {
				teachers.add(teacher);
				teacher.getName();
			}

			@Override
			public String toString() {
				return "Student [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country
						+ ", teachers=" + teachers + "]";
			}

			

}