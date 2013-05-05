package pt.ulht.es.cookbook.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CookbookManager {
    
	private static int NextRecipe_ID = 1;
	private static Map<String,Receita> Receitas_Mapa = new HashMap<String,Receita>();
	
	public static void saveReceita(Receita receita) {
		String id = NextRecipe_ID+"";
		Receitas_Mapa.put(id,receita);
		receita.setId(id);
		NextRecipe_ID++;
	}

	public static Receita getReceita(String id) {

		return Receitas_Mapa.get(id);
	}

	public static Collection<Receita> getReceita() {
		return Receitas_Mapa.values();
		
	}

}
/*
public class CookbookManager;

class TodoList {
	DateTime creationTimestamp;
}

public class Todo {
	String text;
	DateTime creationTimestamp;
	DateTime completionTimestamp;
}

relation TodoManagerHasTodoLists {
	TodoManager playsRole todoManager { multiplicity 1..1; }
	TodoList playsRole todoList { multiplicity 0..*; }	
}

relation TodoManagerHasTodos {
	TodoList playsRole todoList { multiplicity 1..1; }	
	Todo playsRole todo { multiplicity 0..*; }
}*/