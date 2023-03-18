package com.simplilearn.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.demo.POJO.BankDetails;

public interface BankRepo extends JpaRepository<BankDetails, Integer> {
	@Query("Select bd.balance from BankDetails bd where bd.bid=?1")
	public long getBalance(int bid);
}