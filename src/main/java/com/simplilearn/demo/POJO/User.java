	package com.simplilearn.demo.POJO;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	
	import lombok.Data;
	
	@Data
	@Entity
	public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int uid;
		private String u_fname;
		private String u_lname;
		private String email;
		private String uusername;
		private String upassword;
		
	
	}