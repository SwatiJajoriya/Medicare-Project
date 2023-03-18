package com.simplilearn.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.demo.POJO.Purchase;

public interface PurchaseRepo  extends JpaRepository<Purchase, Integer> {

}
