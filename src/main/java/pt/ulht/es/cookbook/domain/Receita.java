package pt.ulht.es.cookbook.domain;

import org.joda.time.DateTime;

public class Receita extends Receita_Base implements Comparable<Receita> {
 
	public Receita(String Titulo,String Problema,String Autor,String Solucao,String tags){
		setTitulo(Titulo);
		setProblema(Problema);
		setAutor(Autor);
		setSolucao(Solucao);
		setCreationTimestamp(new DateTime());
		setTags(tags);
	    setCookbookManager(CookbookManager.getInstance());
	}

	public int compareTo(Receita a) {
		return getTitulo().toLowerCase().compareTo(a.getTitulo().toLowerCase());
	}
	
	public void delete() {
		setCookbookManager(null);
		super.deleteDomainObject();
		
	}

	public void edit() {
		setCookbookManager(null);	
	}

public boolean match(String[] tokens) {
		for(String token : tokens)
		{
			if (getTitulo().contains(token) 
				|| getProblema().contains(token)
				|| getSolucao().contains(token)
				|| getAutor().contains(token)
				|| getTags().contains(token)){
				return true;
			}		
		}
		return false;
		
	}
	
}
