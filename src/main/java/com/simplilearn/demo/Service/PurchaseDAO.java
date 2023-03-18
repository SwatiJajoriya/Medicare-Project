package com.simplilearn.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.POJO.Purchase;
import com.simplilearn.demo.Repo.PurchaseRepo;



@Service
public class PurchaseDAO {
	@Autowired
	PurchaseRepo repo;
	
	public Purchase insert(Purchase p) {
		return repo.save(p);
	}
	
	public List<Purchase> getall(){
		return repo.findAll();
	}
}