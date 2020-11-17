package Stockage;

import java.util.ArrayList;
import java.util.LinkedList;

import metier.Pompier;

public class MemoPompier {
	
		private ArrayList<Pompier> listePompier;

	    public MemoPompier() {
	        this.listePompier = new ArrayList<Pompier>();
	    }

	    //retourne la liste chaînée
	    public ArrayList<Pompier> getListePompier (){
	        return this.listePompier;
	    }
	    
	    //ajoute un objet en fin de collection
	    public void add(Pompier unPompier) {
	        listePompier.add(unPompier);
	    }

	    //recupére un objet à l'indice i
	    public Pompier get(int i) {
	        return this.listePompier.get(i);
	    }

	    //nombre d'objets insérés
	    public int cardinal (){
	        return this.listePompier.size();
	    }

	    public boolean contient(Pompier unPompier)
	    {
	    	return( listePompier.contains(unPompier));
	    }
	    
	    public boolean extraire(Pompier unPompier)
	    {
	    	return listePompier.remove(unPompier);
	    }
	    
	    public Pompier extraire(int i)
	    {
	    	return listePompier.remove(i);
	    }

	    public void vider()
	    {
	    	listePompier.clear();
	    }
	    
	    @Override
	    public String toString()
	    {
	    	 String ch = "";
			for (Pompier pompier : listePompier) {
				ch += pompier.toString() + "\n";
			}
	    	 return ch;
	    }

	  
}
