package br.ibm.sce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ibm.sce.model.Chamado;
import br.ibm.sce.model.Estoque;
import br.ibm.sce.repository.ChamadoRepository;
import br.ibm.sce.repository.EstoqueRepository;

@Controller
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository er;
	
	@Autowired
	private ChamadoRepository cr;
	
	
	// Mapeia a tela de login
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	// Mapeamento do erro de login
	 @RequestMapping("/login-Error")
	 public String loginError(Model model) {
	   model.addAttribute("loginError", true);
	   return "/login";
	 }
	
	//Mapeia o index e mostra a lista
	@RequestMapping("/")
	public ModelAndView listaEstoque(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Estoque> estoques = er.findAll();
		mv.addObject("estoques", estoques);
		
		return mv;
	}
	
	//Mapeia o add
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(){
		return "/add";
	}
	
	//Adiciona os dados na tabela estoque
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addpost(@Valid Estoque estoque, BindingResult result, RedirectAttributes attributes){
		
		String pativo = "NAO";
		String chm = "NP";
		
		estoque.setPosdoativo(pativo);
		estoque.setCham(chm);
		estoque.setTecatresp(chm);
		
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Por favor, preencher todos os campos!");
			return "redirect:/add";
		}
		if(er.findBySerie(estoque.getSerie()) != null) {
			attributes.addFlashAttribute("mensagem", "Serie já existe!");
			return "redirect:/add";
		}
		
		er.save(estoque); 
		
		return "redirect:/";
	}
	
	//Busca os dados via ID e mostra na tabela e no input
	@RequestMapping(value="/edit{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") long id) {
		Estoque estoques = er.findById(id);
		ModelAndView mv = new ModelAndView("/edit");
		mv.addObject("estoques", estoques);
			
		return mv ;
	}
	
	//Edita os dados e efetua o update na tabela estoque
	@RequestMapping(value="/edit{id}", method=RequestMethod.POST)
		public String editPost(@PathVariable("id") long id, @Valid Estoque estoque, BindingResult result, RedirectAttributes attributes) {
			
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Por favor, preencher todos os campos!");
			return "redirect:/edit";
		}
		
		String pativo = "NAO";
		Estoque estoques = er.findById(id);
		estoque.setPosdoativo(pativo);
		estoque.setCham(estoques.getCham());
		estoque.setTecatresp(estoques.getTecatresp());
				
		er.save(estoque);
	
		return "redirect:/";
	}	
	
	//Busca os dados via ID e mostra no form de Asset
	@RequestMapping(value="/addasset{id}", method=RequestMethod.GET)
		public ModelAndView addasset(@PathVariable("id") long id) {
		Estoque estoques = er.findById(id);
		ModelAndView mv = new ModelAndView("/addasset");
		mv.addObject("estoques", estoques);
		
		Iterable<Chamado> chamado = cr.findByEstoque(estoques);
		mv.addObject("chamados", chamado);
			
		return mv ;
	}
	
	//Adiciona o chamado na tabela
	@RequestMapping(value="/addasset{id}", method=RequestMethod.POST)
		public String addassetpost(@PathVariable("id") long id,@Valid Estoque estoque, @Valid Chamado chamado, BindingResult result, RedirectAttributes attributes) {
					
			if(result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Por favor, preencher todos os campos!");
				return "redirect:/addasset";
			}
			
			String pativo = "SIM"; 
			estoque.setPosdoativo(pativo);
			
			Estoque estoques = er.findById(id);	
			
			estoque.setCham(chamado.getChamados());
			estoque.setTecatresp(chamado.getNometec());
			chamado.setChstativo(estoque.getStdoativo());
			chamado.setEstoque(estoques);
			
			
			er.save(estoque);
			cr.save(chamado);
			return "redirect:/";
	}
	
	// Mapeia a tela de imprimir	
	@RequestMapping(value="/termoimp{id}", method=RequestMethod.GET)
	public ModelAndView termoimp(@PathVariable("id") long id) {
		Estoque estoques = er.findById(id);
		ModelAndView mv = new ModelAndView("/termoimp");
		mv.addObject("estoques", estoques);
			
		return mv ;
	}
}