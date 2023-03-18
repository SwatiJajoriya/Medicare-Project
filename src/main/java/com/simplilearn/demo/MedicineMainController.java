package com.simplilearn.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.demo.POJO.BankDetails;
import com.simplilearn.demo.POJO.Purchase;
import com.simplilearn.demo.Service.BankDAO;
import com.simplilearn.demo.Service.PurchaseDAO;
import com.simplilearn.demo.POJO.Admin;
import com.simplilearn.demo.POJO.Medicine;
import com.simplilearn.demo.POJO.User;
import com.simplilearn.demo.Service.AdminDAO;
import com.simplilearn.demo.Service.MedicineDAO;
import com.simplilearn.demo.Service.UserDAO;


@Controller
public class MedicineMainController {
	@Autowired
	MedicineDAO mdao;
	
	@Autowired
	AdminDAO adao;
	
	@Autowired
	UserDAO udao;
	
	@Autowired
	BankDAO bdao;
	
	@Autowired
	PurchaseDAO pdao;
	private final String FOLDER_PATH="D:\\Project image\\";

	
	
	@RequestMapping("/")
	public ModelAndView displaypage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("medicarewebsitepage.jsp");
		return mv;
	}
	
	@RequestMapping("/checkadmin")
	public ModelAndView chkAdmin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Admin e=new Admin();
		e.setAusername(request.getParameter("adusnm"));
		String user=e.getAusername();
		e.setApassword(request.getParameter("adpass"));
		String pass=e.getApassword();
		String pass1=adao.getPassword(user);
		if(pass1!=null) {
			if(pass.equals(pass1)) {
				String msg="Welcome Admin ";
				mv.addObject("msg",msg);
				mv.setViewName("adminhomepage.jsp");
			}
			else {
				String msg="Check credentials and try again..Incorrect Password!!";
				mv.addObject("msg",msg);
				mv.setViewName("adminlogin1.jsp");
			}
			
		}
		else {
			String msg="Not a registered admin!!Try Again..";
			mv.addObject("msg",msg);
			mv.setViewName("adminlogin1.jsp");
		}
		return mv;
	}	

	@RequestMapping("/updateadmpass")
	public ModelAndView editPassAdm(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Admin a=new Admin();
		a.setAusername(request.getParameter("adusnm"));
		String usnm=a.getAusername();
		int aid=adao.getId(usnm);
		a.setAid(aid);
		a.setApassword(request.getParameter("adpass"));
		Admin aa=adao.updatePass(a);
		if(aa!=null) {
			String msg="Updated Successfully!!";
			mv.addObject("msg",msg);
			mv.setViewName("adminlogin1.jsp");
		}
		return mv;
		
	}
	@RequestMapping("/insertmedicine")
	public ModelAndView medicineinsertControl(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Medicine m=new Medicine();
		m.setName(request.getParameter("name"));
		m.setDescription(request.getParameter("description"));
		m.setCategory(request.getParameter("category"));
		m.setBrand(request.getParameter("brand"));
		m.setPrice(Integer.parseInt(request.getParameter("price")));
		String fileinfo=FOLDER_PATH+file.getOriginalFilename();
		m.setImage(fileinfo);
		m.setAvailability(request.getParameter("avail"));
		
		Medicine medicine=mdao.insert(m);
		if(medicine!=null) {
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
		
	@RequestMapping("/medicinelist1")
	public ModelAndView displayAllmedicine(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Medicine> list=mdao.getall();
		 mv.addObject("list",list);
	    mv.setViewName("medicinelist.jsp");
	   	

		return mv;
	}
	
	@RequestMapping("/updatemedicine")
	public ModelAndView medicineupdateControl(HttpServletRequest request,HttpServletResponse response,@RequestParam("file")MultipartFile file) {
		ModelAndView mv=new ModelAndView();
		Medicine m=new Medicine();
		m.setId(Integer.parseInt(request.getParameter("id")));
		m.setName(request.getParameter("name"));
		m.setDescription(request.getParameter("description"));
		m.setCategory(request.getParameter("category"));
		m.setBrand(request.getParameter("brand"));
		m.setPrice(Integer.parseInt(request.getParameter("price")));
		String fileinfo=FOLDER_PATH+file.getOriginalFilename();
		m.setImage(fileinfo);
		m.setAvailability(request.getParameter("avail"));
		Medicine medicine=mdao.update(m);
		if(medicine!=null) {
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/deletemedicine")
	public ModelAndView medicinedeleteControl(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Medicine m=new Medicine();
		m.setId(Integer.parseInt(request.getParameter("id")));
        mdao.delete(m);
		mv.setViewName("success.jsp");
        return mv;
	}
	@RequestMapping("/searchmedicine")
	public ModelAndView searchControl (HttpServletRequest request,HttpServletResponse response,@Param("keyword")String keyword) {
		
		ModelAndView mv=new ModelAndView();
		List<Medicine> listAll=mdao.searchAll(keyword);
		mv.setViewName("medicinelist.jsp");
		mv.addObject("list",listAll);	
			return mv;
		
	}
	
	@RequestMapping("/filtermedicine")
	public ModelAndView filterbyControl(HttpServletRequest request,HttpServletResponse response,@Param("keyword")String keyword) {
		
		ModelAndView mv=new ModelAndView();
		List<Medicine> listAll=mdao.filterby(keyword);
		mv.setViewName("medicinelist.jsp");
		mv.addObject("list",listAll);	
			return mv;
		
	}
	
	@RequestMapping("/sortmedicine")
	public ModelAndView sortControl(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
	String keyword=request.getParameter("list");
	if(keyword.equalsIgnoreCase("ASC")) {
		List<Medicine> listAll=mdao.getAllAsc();
		mv.setViewName("medicinelist.jsp");
		mv.addObject("list",listAll);	
			
	}
	else {
		List<Medicine> listAll=mdao.getAllDesc();
		mv.setViewName("medicinelist.jsp");
		mv.addObject("list",listAll);	
	}
			
			return mv;
		
	}
	
	
	@RequestMapping("/checkuser")
	public ModelAndView checkusercontrol(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u= new User();
		u.setUusername(request.getParameter("uusnm"));
		String username=u.getUusername();
		u.setUpassword(request.getParameter("upass"));
		String password=u.getUpassword();
		String password1=udao.userPwd(username);
		String cname=udao.findtheName(username);
		if(password1!=null) {
			if(password1.equals(password)) {
				String msg="Welcome "+cname+" to Medicare!!";
				mv.addObject("msg",msg);
				mv.addObject("cname",cname);
				mv.setViewName("showmedicinetouser1.jsp");
			}
			else {
				String msg="Login Falied,Incorrect Password!!";
				mv.addObject("msg",msg);
				mv.setViewName("userlogin1.jsp");
			}
			
		}
		else {
			String msg="Not a Registered User!!Click to SignUp";
			mv.addObject("msg",msg);
			mv.setViewName("userlogin1.jsp");
		}
		
	return mv;
	}
	
	@RequestMapping("/insertuser")
	public ModelAndView insertusercontrol(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u= new User();
		u.setU_fname(request.getParameter("ufname"));
		String cname=u.getU_fname();
		u.setU_lname(request.getParameter("ulname"));
		u.setEmail(request.getParameter("uemail"));
		u.setUusername(request.getParameter("uusnm"));
		u.setUpassword(request.getParameter("upass"));
		
		User uu=udao.insert(u);
		if(uu!=null) {
			String msg="Welcome "+cname+" to Medicare!!";
			mv.addObject("msg",msg);
			mv.addObject("cname",cname);
			mv.setViewName("showmedicinetouser1.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/showmedicineuser")
	public ModelAndView showuserMedicinecontrol(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Medicine> list=mdao.getall();
		String cname=request.getParameter("cname");
		System.out.println(cname);
		mv.addObject("list",list);
		mv.addObject("cname",cname);
		mv.setViewName("showmedicinetouser.jsp");
		return mv;
	}
	
	@RequestMapping("/displayalluser")
	public ModelAndView displayallusercontrol(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<User> list=udao.getAllUsers();
		mv.addObject("list",list);
		mv.setViewName("usernamelist.jsp");
		return mv;
	}
	@RequestMapping("/deleteuser")
	public ModelAndView dltUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u=new User();
		u.setUid(Integer.parseInt(request.getParameter("uid")));
		String ss=udao.delete(u);
		if(ss!=null) {
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}

	return mv;
	}
	
	@RequestMapping("/usersortmedicine")
	public ModelAndView usersortControl(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
	String keyword=request.getParameter("list");
	
	if(keyword.equalsIgnoreCase("ASC")) {
		List<Medicine> listAll=mdao.getAllAsc();
		mv.setViewName("showmedicinetouser.jsp");
		mv.addObject("list",listAll);	
			
	}
	else {
		List<Medicine> listAll=mdao.getAllDesc();
		mv.setViewName("showmedicinetouser.jsp");
		mv.addObject("list",listAll);	
	}
			return mv;
		
	}
	
	@RequestMapping("/usersearchmedicine")
	public ModelAndView usersearchControl (HttpServletRequest request,HttpServletResponse response,@Param("keyword")String keyword) {
		
		ModelAndView mv=new ModelAndView();
		List<Medicine> listAll=mdao.searchAll(keyword);
		mv.setViewName("showmedicinetouser.jsp");
		mv.addObject("list",listAll);	
			return mv;
		
	}
	
	@RequestMapping("/userfiltermedicine")
	public ModelAndView userfilterbyControl(HttpServletRequest request,HttpServletResponse response,@Param("keyword")String keyword) {
		
		ModelAndView mv=new ModelAndView();
		List<Medicine> listAll=mdao.filterby(keyword);
		mv.setViewName("showmedicinetouser.jsp");
		mv.addObject("list",listAll);	
			return mv;
		
	}
	
	@RequestMapping("/proceedpay")
	public ModelAndView payment(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		int price=Integer.parseInt(request.getParameter("price"));
		BankDetails bd=new BankDetails();
		bd.setBid(Integer.parseInt(request.getParameter("bid")));
		int bid=bd.getBid();
		long balance=bdao.getBalance(bid);
		
		if(balance>price) {
			Purchase p=new Purchase();
			p.setName(request.getParameter("cname"));
			p.setMname(request.getParameter("mname"));
			p.setMprice(request.getParameter("mprice"));
			Purchase pp=pdao.insert(p);
			mv.setViewName("paysuccess.jsp");
		}
		else {
			mv.setViewName("payfail.jsp");
		}
		return mv;
}
	
	@RequestMapping("/purchaserepo")
	public ModelAndView purchaserepo(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Purchase> list=pdao.getall();
		mv.addObject("list",list);
		mv.setViewName("purchaselist.jsp");
		return mv;
		
	}
}
