package pt.ulht.es.cookbook.domain;

import java.util.Date;




public class Receita {
	//variaveis do objecto
	
    public String _id;
	public String _titulo;
	public String _problema;
	public String _autor;
	public String _solucao;
	public Date _data;
	
	
	

	public Receita(String Titulo,String Problema,String Autor,String Solucao){
		setTitulo(Titulo);
		setProblema(Problema);
		setAutor(Autor);
		setSolucao(Solucao);
		setData(new Date());
	}
	
	/*definições dos sets e gets*/
	public String getTitulo(){
		return _titulo;
	}
	
	public Date getData(){
		return _data;
	}
	
	public  void setData(Date data){
		this._data= data;
	}
	
	public void setTitulo(String titulo){
		_titulo = titulo;
	}
	
	public String getProblema(){
		return _problema;
	}
	
	public void setProblema(String problema){
		_problema = problema;
	}
	
	public String getAutor(){
		return _autor;
	}
	
	public void setAutor(String autor){
		_autor = autor;
	}
	
	public String getSolucao(){
		return _solucao;
	}
	
	public void setSolucao(String solucao){
		_solucao = solucao;
	}

	public String getId() {
		
		return _id;
	}

	public void setId(String id) {
		_id = id;
		
	}
	
	
	
}
