package com.simplilearn.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.simplilearn.demo.POJO.Medicine;
import com.simplilearn.demo.Service.MedicineDAO;



@RestController
public class MedicineRestController {
	
	@Autowired
	MedicineDAO mdao1;
	
	@PostMapping("/insertmedi")
public Medicine insert(@RequestBody Medicine m,MultipartFile image) {
		
		return mdao1.insert(m);
	}
	
	@PostMapping("/insertallmedi")
	public List<Medicine> insertall(@RequestBody List<Medicine> m){
		return mdao1.insertall(m);
	}
	
	@GetMapping("/getallmedi")
	public List<Medicine> getall(){
		return mdao1.getall();
	}
	
	@DeleteMapping("deletemedibyid/{id}")
	public String deletebyid(@PathVariable("id") int id) {
		mdao1.deletebyid(id);
		return "Deleted the id value of "+ id;
	}
	
	@PutMapping("/updatemedi")
	public Medicine update(@RequestBody Medicine m) {
		return mdao1.update(m);
	}
	
	
	@GetMapping("/getmedibyname/{name}/{id}")
	public String findbyname(@PathVariable("name") String name,@PathVariable("id") int id) throws Exception{
		if(mdao1.findbyname(name, id)!=null) {
			return mdao1.findbyname(name, id);
		}
		else {
			throw new Exception("the name and the id is not found");
		}
	}

}
