package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Time;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.TimeRepository;



@Controller
public class TimeController {
	
	@Autowired
	private TimeRepository timeRepository;
	
	@GetMapping("/times")
	public String times (Model model) {
		
		List<Time> times = timeRepository.findAll();
		model.addAttribute("times", times);
		
		return "indexTime";
	}
	

	@GetMapping("")
	public String index(Model model) {
		
		List<Time> times = timeRepository.findAll();
		model.addAttribute("times", times);
		
		return "indexTime";
	}
	
	
	
	@GetMapping("/times/form")
	public String timeForm(@ModelAttribute("time") Time time) {
		
		return "time_form";
	}
	
	@PostMapping("/times/new")
	public String timeNew(@ModelAttribute("time=") Time time) {
		
		timeRepository.save(time);
		return "redirect:/indexTime";
	}
	
	@GetMapping("/times/update/{id}")
	public String timeUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Time> optTime = timeRepository.findById(id);
		
		if(!optTime.isPresent()) {
			//Gerar erro
		}
		
		Time time = optTime.get();
		
		model.addAttribute("Time", time);
		
		return "time_form";
	}
	
	@GetMapping("/times/delete/{id}")
	public String timeDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Time> optTime = timeRepository.findById(id);
		
		if(!optTime.isPresent()) {
			//Gerar erro
		}
		
		Time time = optTime.get();
		
		timeRepository.delete(time);
		
		return "redirect:/indexTime";
	}
}
