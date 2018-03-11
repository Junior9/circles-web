package com.eg.circles.circles_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Employeer;
import com.eg.circles.circles_web.service.EmployeerService;

@RestController
public class EmployeerController {
	
	@Autowired
	private EmployeerService employeerService;
	
	@GetMapping("/employeer/all")
	public List<Employeer> getAll(){
		return employeerService.getAll();
	}
	
	@GetMapping("/employeer/{idEmployeer}")
	public Employeer get(@PathVariable int idEmployeer) {
		return employeerService.get(idEmployeer);
	}
	
	@PostMapping("/employeer/save")
	public Employeer save(Employeer employeer) {
		return employeerService.save(employeer);
	}

	@DeleteMapping("/employeer/delete")
	public void delete(@PathVariable int idEmployeer) {
		employeerService.delete(idEmployeer);
	}
}