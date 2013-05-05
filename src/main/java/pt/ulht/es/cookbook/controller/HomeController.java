package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //
public class HomeController {
  
	@RequestMapping(method=RequestMethod.GET, value="/")// fazer mapeamento do contexto no controlador
	public String showHome(Model model) {
		//classe do spring que representa o modelo ex:model.atribute
		
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));
	    
		return "home";
	}

}