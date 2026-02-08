package com.learning.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.springmvcboot.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="aliens",produces= {"application/xml"})
	@ResponseBody
	public List<Alien> getAliens()
	{
		System.out.println("Inside getAliens method");
		List<Alien> aliens = repo.findAll();
		return aliens;
	}
	
	@GetMapping("alien/{aid}")
	@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid)
	{
		// Alien alien = repo.getById(aid);
		Alien alien = repo.findById(aid).orElse(new Alien(0,""));
		return alien;
	}
	
	@PostMapping(path="alien",consumes={"application/json"})
	@ResponseBody
	public Alien addAlien(@RequestBody Alien a)
	{
		repo.save(a);
		return a;
	}
}
