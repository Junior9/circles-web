package com.eg.circles.circles_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Employeer;
import com.eg.circles.circles_web.service.EmployeerService;

@RestController
public class EmployeerController {
	
	@Autowired
	private EmployeerService employeerService;
	
	@GetMapping("/employeer/all")
	public Iterable<Employeer> getAll(){
		return employeerService.getAll();
	}
	
	@GetMapping("/employeer/{id}")
	public Employeer get(@PathVariable int id) {
		return employeerService.get(id);
	}
	
	@PostMapping(value="/employeer/save",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employeer save(@RequestBody Employeer employeer) {
		return employeerService.save(employeer);
	}

	@DeleteMapping("/employeer/delete/{id}")
	public void delete(@PathVariable int id) {
		employeerService.delete(id);
	}
}