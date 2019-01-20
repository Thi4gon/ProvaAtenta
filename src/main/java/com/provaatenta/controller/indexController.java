package com.provaatenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.provaatenta.model.Sapato;
import com.provaatenta.repository.SapatoRepository;

@Controller
public class indexController {



		@Autowired
		SapatoRepository repositorio;
		
		@GetMapping("/")
		public String index(){
			
		
			return "index";
		}
		
	
}
