package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;

	@GetMapping //irá responder a requisição HTTP do tipo GET
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		
		modelAndView.addObject("convidado", new Convidado());
		
		return modelAndView;
	}
	
	
	@PostMapping //irá responder a requisição HTTP do tipo POST
	public String salvar(Convidado convidado) {
		
		this.convidados.save(convidado);
		
		return "redirect:/convidados";
	}
	
	
}
