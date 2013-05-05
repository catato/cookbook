package pt.ulht.es.cookbook.controller;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.sql.Timestamp;  

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
  


import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Receita;
import java.util.Date;
import java.text.SimpleDateFormat;

   @Controller
   public class RecipeController {
   public static ArrayList<Receita> _receitas = new ArrayList<Receita>();
	
   	
  
   
   
 /********************************CRIAR RECEITAS************************************************/
   @RequestMapping(method = RequestMethod.GET, value = "/criar")
   public String formularioCriarReceita() {
       return "Criar";
     
   }
 
 	@RequestMapping(method = RequestMethod.POST, value = "/redirect", params = "criarReceita")
 	public String criarReceita(Model model,@RequestParam Map<String,String>params ){
 		String titulo = params.get("txtTitulo");
 		String problema = params.get("txtproblema");
 		String autor = params.get("txtautor");
 		String solucao = params.get("txtsolucao");
 		
 
		Receita receita = new Receita(titulo,problema,autor,solucao);  /*inicializacao de um objecto*/
 		CookbookManager.saveReceita(receita);
 		model.addAttribute("receita", receita);
 	    _receitas.add(receita);
 	    
		return "redirect:/receitas/"+receita.getId(); 
 		 //return "home";
 		
 	 	}	
 	
   
  /**************************LISTAR RECEITAS*********************************/
	
	@RequestMapping(method = RequestMethod.GET, value = "/ListarReceita")
	public String listRecipes(Model model){
		Collection <Receita> receita = CookbookManager.getReceita();
		model.addAttribute("receita",receita);
		
		SimpleDateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		DateFormat df1 = DateFormat.getDateInstance();
		model.addAttribute("data", df1.format(time));
		return "listRecipes";
		
	   
		
		
	} 


   /**************************DETALHES RECEITAS************************/
	
	@RequestMapping(method = RequestMethod.GET, value = "/receitas/{id}")
         public String showRecipe(@PathVariable("id") String id, Model model) {
         Receita receita = CookbookManager.getReceita(id);
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
