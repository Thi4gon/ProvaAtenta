package com.provaatenta.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.provaatenta.model.Comentario;
import com.provaatenta.model.Sapato;
import com.provaatenta.repository.ComentarioRepository;
import com.provaatenta.repository.SapatoRepository;

@Controller
public class SapatoController {

	@Autowired
	private SapatoRepository repositorioS;
	
	@Autowired
	private ComentarioRepository repositorioCom;
	

//pegar sapatos
	@RequestMapping(value="/cadastroSapato", method=RequestMethod.GET)
	public String cadastrarSapatos() {
	
		return "sapatos/formSapato";
	}
	
	
	//cadastrar sapatos no banco
	@RequestMapping(value="/cadastroSapato", method=RequestMethod.POST)
	public String cadastrarSapatos(Sapato sapato,BindingResult result, RedirectAttributes attributes) {
	
		repositorioS.save(sapato);
		attributes.addFlashAttribute("mensagemCad","Sapato Cadastrado com Sucesso!");
		return "redirect:/cadastroSapato";
	}
	
	//buscar todos sapatos para lista
	@RequestMapping("/sapatos")
	public ModelAndView listaSapatos() {
		ModelAndView modelo = new ModelAndView("index");
		Iterable<Sapato> sapatos = repositorioS.findAll(); // buscar todos sapatos
		modelo.addObject("sapatos", sapatos);
		
		return modelo;
	}
	
	
	//pegar comentarios
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesSapt(@PathVariable(name="id") Long id ) {
		Sapato sapato = repositorioS.findById(id).get();
		ModelAndView modelo = new ModelAndView("sapatos/detalheSapato");
		modelo.addObject("sapato",sapato);
		
		Iterable<Comentario> comentarios = repositorioCom.findBySapato(sapato); // PEGAR O COMENTARIO E A ULTIMA DATA DE UTILIZAÇÃO por sapato
		modelo.addObject("comentarios",comentarios);
		
		return modelo;
	}
	
	//deletar sapato
	@RequestMapping("/deletar")
	public String deletaSapatos(long id) {
		Sapato sapato = repositorioS.findById(id).get();
		repositorioS.delete(sapato);
		
		
		return "redirect:/sapatos";
	}
	
	//salvar comentarios
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesComen(@PathVariable(name="id") Long id ,Comentario comentario, BindingResult result, RedirectAttributes attributes) {
	Sapato sapato = repositorioS.findById(id).get();
	comentario.setSapato(sapato);
	repositorioCom.save(comentario);
	attributes.addFlashAttribute("mensagem","Comentario Salvo");
		return "redirect:/{id}";
	}
	
	
	
//deletar comentarios
	@RequestMapping("/deletarC")
	public String deletaComent(String ultimaUlt) {
		Comentario comentario = repositorioCom.findByUltimaUlt(ultimaUlt);
		repositorioCom.delete(comentario);
		
		Sapato sapato= comentario.getSapato();
		long codigoLong = sapato.getId();
		String id = "" + codigoLong;    // CRIO A STRING PORCAUSA DO RETURN
		
		return "redirect:/"+id;
	}
	
	
//Filtrar por marca
	@RequestMapping("/sapatosPorMarca")
	public ModelAndView filtroMarca(String marcaSapato) {
		ModelAndView modelo = new ModelAndView("index");
		Iterable<Sapato> sapatos = repositorioS.findBymarcaSapato(marcaSapato); // buscar todos sapatos por marca
		modelo.addObject("sapatos", sapatos);
		
		return modelo;
	}
	
	
//Filtrar por estilo
	@RequestMapping("/sapatosPorEstilo")
	public ModelAndView filtroEstilo(String estiloSapato) {
		ModelAndView modelo = new ModelAndView("index");
		Iterable<Sapato> sapatos = repositorioS.findByestiloSapato(estiloSapato); // buscar todos sapatos por marca
		modelo.addObject("sapatos", sapatos);
			
		return modelo;
	}
		
	
//Filtrar por cor
		@RequestMapping("/sapatosPorCor")
		public ModelAndView filtroCor(String corSapato) {
			ModelAndView modelo = new ModelAndView("index");
			Iterable<Sapato> sapatos = repositorioS.findBycorSapato(corSapato); // buscar todos sapatos por marca
			modelo.addObject("sapatos", sapatos);
			
			return modelo;
		}
		
	
	
}
