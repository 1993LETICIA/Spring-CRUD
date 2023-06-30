package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Jogador;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Time;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.JogadorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.TimeRepository;



@Controller
public class JogadorController {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@GetMapping("/jogadores")
	public String jogadores(Model model) {
		
		List<Jogador> jogadores = jogadorRepository.findAll();
		model.addAttribute("jogadores", jogadores);
		
		return "indexJogadores";
	}
	
	@GetMapping("/jogadores/form")
	public String jogadorForm(Model model, @ModelAttribute("jogador")Jogador jogador) {
		List<Time> times = timeRepository.findAll();
		model.addAttribute("times",times);
		return "jogador_form";
	}
	
	@PostMapping("/jogadores/new")
	public String jogadorNew(@Valid 
			@ModelAttribute("jogador") Jogador jogador, 
			BindingResult bindingResult, Model model) {
		
		
		if(bindingResult.hasErrors()) {
			List<Time> times = timeRepository.findAll();
			model.addAttribute("times",times);
			return "jogador_form";
		
		}
		jogadorRepository.save(jogador);
		return "redirect:/jogadores";
	
	}
	@GetMapping("/jogadores/update/{id}")
	public String jogadorUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Jogador> optJogador = jogadorRepository.findById(id);
		
		if(!optJogador.isPresent()) {
			//Gerar erro
		}
		
		Jogador jogador = optJogador.get();
		
		model.addAttribute("jogador", jogador);
		
		List<Time> times = timeRepository.findAll();
		model.addAttribute("times",times);
		
		return "jogador_form";
	}
	
	@GetMapping("/jogadores/delete/{id}")
	public String jogadorDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Jogador> optJogador = jogadorRepository.findById(id);
		
		if(!optJogador.isPresent()) {
			//Gerar erro
		}
		
		Jogador jogador = optJogador.get();
		
		jogadorRepository.delete(jogador);
		
		return "redirect:/jogadores";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
