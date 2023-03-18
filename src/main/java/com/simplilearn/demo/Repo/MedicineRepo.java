package com.simplilearn.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.simplilearn.demo.POJO.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer>{
	
	//query for restcontroller
		@Query("select m.name from Medicine m where m.name=?1 and m.id=?2")
		public String findByname(String name,int id);
		
		//User medicine list display
		//@Query("Select m from Medicine m where m.availability='IN-STOCK'")
		//public List<Medicine> userListOfMedicine();
		
		//Search query for main controller
		@Query("Select m from Medicine m where m.name LIKE %?1%"+"OR m.category LIKE %?1%" +"OR m.brand LIKE %?1%" +"OR m.availability LIKE %?1%")
		public List<Medicine> search(String keyword);
		
		//filter admin
		@Query("Select m from Medicine m where m.category=?1"+"OR m.brand=?1")
		public List<Medicine> filterBy(String keyword);

}
