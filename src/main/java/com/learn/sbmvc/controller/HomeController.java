package com.learn.sbmvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learn.sbmvc.dao.AlienRepo;
import com.learn.sbmvc.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;

	// ModelAttribute at Method Level...
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Aliens"); // This will be available everywhere
	}

	@RequestMapping("/")
	public String home() {
//		System.out.println("Home page requested!");

		// will download jsp without tomcat-jasper library
//		return "index.jsp"; // webapp/index.jsp : public [accessible via url]

		// NOTE: To make pages private add them into WEB-INF folder

		return "index"; // webapp/views/index.jsp

	}

//	@RequestMapping("add")
//	public String add(HttpServletRequest req) {
//		// Accepting user inputs...
//		int p = Integer.parseInt(req.getParameter("num1"));
//		int q = Integer.parseInt(req.getParameter("num2"));
//		
//		int num3 = p + q;
//		
//		HttpSession session = req.getSession();
//		
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//		// or
//		//return "result.jsp?num3=" + num3; // URL-rewriting
//		
//	}

	// RequestParam...
//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int p, @RequestParam("num2") int q, HttpSession session) {
//		int num3 = p + q;
//		session.setAttribute("num3", num3);
//		return "result.jsp"; 
//	}

	// ModelAndView and spring mvc properties suffix and prefix...
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1") int p, @RequestParam("num2") int q) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result"); // view // (static page)
//		int num3 = p + q;
//		mv.addObject("num3", num3); // data
//		return mv;
//	}

	// Model and ModelMap...
	@RequestMapping("add")
	public String add(@RequestParam("num1") int p, @RequestParam("num2") int q, ModelMap m) {
		int num3 = p + q;
		m.addAttribute("num3", num3);
		return "result";
	}

	// Need of ModelAttribute...
//	@RequestMapping("addAlien") 
//	public String addAlien(@RequestParam("aid") int id, @RequestParam("aname") String name, Model m) {
//		
//		Alien a = new Alien();
//		a.setA_id(id);
//		a.setA_name(name);
//		m.addAttribute("alien", a);
//		return "result";
//	}

	// ModelAttribute
//	@RequestMapping(value = "addAlien", method = RequestMethod.POST)
	// or
	@PostMapping(value = "addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a) {
		repo.save(a);
		return "result";
	}
	
	
	@GetMapping(value = "getAliens")
	public String getAliens(Model m) {
		
//		List<Alien> list = Arrays.asList(new Alien(100, "Luke"), new Alien(100, "Oliver"));
//		m.addAttribute("aliens", list);
		m.addAttribute("aliens", repo.findAll());
		
		//  Pagination...
//		m.addAttribute("aliens", repo.findAliensWithPagination(Pageable.ofSize(2)));
		return "show";
	}
	
	
	@GetMapping(value = "getAlien")
	public String getAlien(@RequestParam(name = "aid") int id, Model m) {
		
		m.addAttribute("aliens", repo.getByAid(id));
		return "show";
	}
	
	@GetMapping(value = "getAlienByName")
	public String getAlienByName(@RequestParam(name = "aname") String name, Model m) {
		
//		m.addAttribute("aliens", repo.getByAname(name));
//		m.addAttribute("aliens", repo.getByAnameOrderByAid(name));
		
//		m.addAttribute("aliens", repo.find(name));
//		m.addAttribute("aliens", repo.findNative(name));
		
		m.addAttribute("aliens", repo.findAlienByName(name));
		
		return "show";
	}
	
	
	@GetMapping(value = "updateAlienName")
	public String updateAlienName(int aid, String aname, Model m) {
		m.addAttribute("aliens", repo.updateAlienSetNameForIdNative(aname, aid));
		return "show";
	}

}
