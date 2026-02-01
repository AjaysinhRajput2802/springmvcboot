package com.learning.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.springmvcboot.model.Alien;

@Controller
public class HomeController {
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","Aliens");
	}
	
	@GetMapping("/")
	public String home()
	{
		System.out.println("home page requested");
		return "index";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		//List<Alien> aliens = Arrays.asList(new Alien(101,"Ajay"), new Alien(102,"Rose"));
		m.addAttribute("result", repo.findAll());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m)
	{
		//List<Alien> aliens = Arrays.asList(new Alien(101,"Ajay"), new Alien(102,"Rose"));
		m.addAttribute("result", repo.getOne(aid));
		return "showAliens";
	}
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname, Model m)
	{
		//List<Alien> aliens = Arrays.asList(new Alien(101,"Ajay"), new Alien(102,"Rose"));
		//m.addAttribute("result", repo.findByAname(aname));
		m.addAttribute("result", repo.find(aname));
		return "showAliens";
	}
	
	@GetMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m)
	{
		//int i = Integer.parseInt(req.getParameter("num1"));
		//int j = Integer.parseInt(req.getParameter("num2"));
		
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("result");*/
		int num3 = i + j;
		//HttpSession session = req.getSession();
		
		//session.setAttribute("num3",num3);
		//mv.addObject("num3",num3);
		m.addAttribute("num3", num3);
		
		//return mv;
		return "result";
	}
	
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a)
	{
		/*Alien a = new Alien();
		a.setAid(aid);
		a.setAname(aname);
		m.addAttribute("alien", a);*/
		repo.save(a);
		return "showAliens";
	}
}
