package com.simplilearn.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.demo.POJO.BankDetails;
import com.simplilearn.demo.Service.BankDAO;

@RestController
public class BankRestController {
	@Autowired
	BankDAO bdao;
	
	
	@PostMapping("/insertbankbypostman")
	public List<BankDetails> insertbank(@RequestBody List<BankDetails> bd){
		return bdao.insertAll(bd);
	}
}
