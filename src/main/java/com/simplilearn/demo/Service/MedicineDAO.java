package com.simplilearn.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.POJO.Medicine;
import com.simplilearn.demo.Repo.MedicineRepo;



@Service
public class MedicineDAO {
	

	@Autowired
	MedicineRepo mrepo;
	
	public Medicine insert(Medicine m) {
		
		return mrepo.save(m);
		}

	public List<Medicine> insertall(List<Medicine> m){
		return mrepo.saveAll(m);
		
	}

	public List<Medicine> getall(){
		return mrepo.findAll();
	}
	//user get all
//	public List<Medicine> getAllMedForUser(){
//		return mrepo.userListOfMedicine();
//	}

	public void deletebyid(int id){
		mrepo.deleteById(id);
	}

	public Medicine update(Medicine m) {
		Medicine medicine=mrepo.findById(m.getId()).orElse(null);
		medicine.setName(m.getName());
		medicine.setDescription(m.getDescription());
		medicine.setCategory(m.getCategory());
		medicine.setImage(m.getImage());
		medicine.setPrice(m.getPrice());
		medicine.setAvailability(m.getAvailability());
		medicine.setBrand(m.getBrand());
		return	mrepo.save(medicine);
		
	}

	public void delete(Medicine m) {
		mrepo.delete(m);

		
	}
	
	//customize query
			public String findbyname(String name,int id){
			return mrepo.findByname(name,id);
			}
			
	// for search
	public List<Medicine> searchAll(String keyword){
		if(keyword!=null) {
			return mrepo.search(keyword);
	}	return null;
	}
	
	// for filter
		public List<Medicine> filterby(String keyword){
			if(keyword!=null) {
				return mrepo.search(keyword);
		}	return null;
		}

		
	//for sorting
		
		public List<Medicine> getAllAsc(){
			
			return mrepo.findAll(Sort.by(Sort.Direction.ASC,"price"));
		}
	     
	     public List<Medicine> getAllDesc(){
	 		
	 		return mrepo.findAll(Sort.by(Sort.Direction.DESC,"price"));
	 	}


}
