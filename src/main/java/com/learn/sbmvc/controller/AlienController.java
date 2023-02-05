package com.learn.sbmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.sbmvc.dao.AlienRepo;
import com.learn.sbmvc.model.Alien;

//@Controller
@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	// produce attribute and "Accept" [in header]...
	
	// produce : production restriction i.e server response either xml or json
	
	@GetMapping(path = "aliens")
//	@GetMapping(path = "aliens", produces = {"application/xml"})
//	@ResponseBody // @ResponseBody sends data as data not Jsp name
	public List<Alien> getAliens() {
		System.out.println("Fetching all aliens...");
//		int i = 10/0;
		return repo.findAll();
	}
	
	
	@GetMapping(path = "alien/{id}")
	public Alien getAlien(@PathVariable("id") int id) {
		return repo.getByAid(id);
	}
	
	// RequestBody and consume Attribute....
	
	// @RequestBody : opposite of @ResponseBody, converts json, xml or other data format into object
	
	@PostMapping(path = "alien", consumes = {"application/json"})
	public void addAlien(@RequestBody Alien alien) {
		repo.save(alien);
	}
	
}
