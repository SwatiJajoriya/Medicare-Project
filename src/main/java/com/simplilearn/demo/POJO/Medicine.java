package com.simplilearn.demo.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Medicine {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private int id;  

	private String name;  

	private String description; 

	private String category;  
	
	private String brand; 
	
    private String image;
    
	private int price; 
	
	private String availability;

}
