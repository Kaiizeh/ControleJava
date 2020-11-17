package metier;

import Stockage.MemoPompier;

public class Caserne {
	//  l' ensemble des pompiers pour la caserne
	private MemoPompier lesPompiers;
	
	// Constructeur
	public Caserne()
	{
		lesPompiers = new MemoPompier();
	}
	
	public void addPompier(Pompier unPompier)
	{
		lesPompiers.add(unPompier);
	}
	
	// Appelle automatiquement le n� de Bip pass� en param�tre
	private void appeler(Pompier unPompier)
	{
		System.out.println(unPompier.getNumeroBip());
	}
	
	// Appelle une �quipe de pompiers pour une intervention concernant la p�riode pass�e en 
	// param�tre. Le param�tre "nbPompiers" repr�sente le nombre de pompiers � solliciter.
	// Si un nombre suffisant de pompiers ne peut pas �tre sollicit�, une �quipe incompl�te sera 
	// appel�e. Cette fonction modifie le statut des pompiers s�lectionn�s, les appelle sur leur bip et retourne 
	// le nombre de pompiers appel�s.
	/*public int appelEquipe (Periode unePeriode, int nbPompier)
	{
		MemoPompier uneEquipe;
		Pompier unPompier;
		uneEquipe = unePeriode.selectEquipe(nbPompier);
		for (int i = 0; i<uneEquipe.cardinal(); i++)
		{
			unPompier  = uneEquipe.get(i);
			unPompier.missionner(unePeriode);
			appeler(unPompier);
		}
		return uneEquipe.cardinal();
	}
	*/
	
	
	// liste tous les Pompiers
	@Override
	public String toString()
	{
		String ch = "";
		for (Pompier pompier : lesPompiers.getListePompier()) {
			ch += pompier.toString() + "\n";
		}
		return ch;
	}
	
	
}
