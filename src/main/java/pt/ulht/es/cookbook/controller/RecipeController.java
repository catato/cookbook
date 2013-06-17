package pt.ulht.es.cookbook.controller;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.Timestamp;  

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
  


import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Receita;
import java.util.Date;
import java.text.SimpleDateFormat;

   @Controller
   public class RecipeController {
   
	
 /********************************CRIAR RECEITAS************************************************/
   /* O request mapping é uma implementacao de metodos que trata da requisicao para um determinado url*/
   
   @RequestMapping(method = RequestMethod.GET, value = "/criar")
   public String formularioCriarReceita() {
       return "Criar";
     
   }
 
 	@RequestMapping(method = RequestMethod.POST, value = "/receitas")
 	public String criarReceita(@RequestParam Map<String,String> params ){
 		
 		String titulo = params.get("txtTitulo");
 		String problema = params.get("txtproblema");
 		String autor = params.get("txtautor");
 		String solucao = params.get("txtsolucao");
 		String tags = params.get("txttags");
 		Receita receita = new Receita(titulo,problema,autor,solucao, tags);  /*inicializacao de um objecto*/
         	    

		return "redirect:/receitas/"+receita.getExternalId(); 
 		
 		
 	 	}	
 	
   
  /**************************LISTAR RECEITAS*********************************/
	@RequestMapping(method = RequestMethod.GET, value = "/ListarReceita")
	 public String listRecipes(Model model){
		 List<Receita> receitas = new ArrayList<Receita>(CookbookManager.getInstance().getReceitaSet());
		 Collections.sort(receitas);
		 model.addAttribute("receitas",receitas);
		 
		 new SimpleDateFormat("DD/MM/YYYY");
			Timestamp time = new Timestamp(System.currentTimeMillis()); 
			DateFormat df1 = DateFormat.getDateInstance();
			model.addAttribute("data", df1.format(time));
			return "listRecipes";
			
		  		
	} 
  /**********************APAGAR RECEITAS********************************************/
	@RequestMapping(method = RequestMethod.GET, value = "receitas/{id}/delete")
	public String apagarReceita(Model model, @PathVariable("id")String id){
		Receita receita = AbstractDomainObject.fromExternalId(id);
		receita.delete();
	
		return "redirect:/ListarReceita";
		
	}	
		
	/**********************EDITAR RECEITAS********************************************/
	@RequestMapping(method = RequestMethod.GET, value = "/editarReceita/{id}")
	public String mostraFormEditar(Model model, @PathVariable("id")String id){
		Receita receita = AbstractDomainObject.fromExternalId(id);
		
		model.addAttribute("receita",receita);
		return "editarReceita";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editarReceita")
	public String editarReceita(@RequestParam Map<String, String> params){
 		
 		String titulo = params.get("txtTitulo");
 		String problema = params.get("txtproblema");
 		String autor = params.get("txtautor");
 		String solucao = params.get("txtsolucao");
 		String tags = params.get("txttags");
 	
 		Receita receita = new Receita(titulo,problema,autor,solucao, tags);  /*inicializacao de um objecto*/
 	    
 		
 		return "redirect:/ListarReceita";
	
	}
	
	/**********************Pesquisar Receitas********************************************/
	@RequestMapping(method = RequestMethod.GET, value = "/pesquisar")
	public String mostraFormPesquisa(){
	
		return "pesquisa";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/receita/pesquisa")
	public String pesquisaReceita(@RequestParam Map<String, String> params, Model model){
 		 
		String parametroDePesquisa = params.get("campoPesquisar");
		String[] tokens = parametroDePesquisa.split(",");
		List<Receita> resultado = new ArrayList<Receita>();
		for(Receita receita : CookbookManager.getInstance().getReceitaSet())
		{
			if(receita.match(tokens))
			{
				resultado.add(receita);
			}
		}
		model.addAttribute("receitas", resultado);
 		return "resultadoPesquisa";
	
	}
	
	
   /**************************DETALHES RECEITAS*************************************/
	
	@RequestMapping(method = RequestMethod.GET, value = "/receitas/{id}")
         public String showRecipe(@PathVariable("id") String id, Model model) {
		Receita receita = AbstractDomainObject.fromExternalId(id);
		
		if(receita != null) {
           model.addAttribute("receita",receita);
           return "detailedRecipe";
	    } else {
	    	
	    	Date date = new Date(System.currentTimeMillis());
			DateFormat df = DateFormat.getDateInstance();
			model.addAttribute("data", df.format(date));
	    return "recipeNotFound";
		     
	    }
	
	 }		
   }	
