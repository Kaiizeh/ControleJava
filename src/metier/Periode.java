package metier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Stockage.MemoPompier;

public class Periode {
	
	private Date laDate;
	private int laTranche;
	private MemoPompier enMission;
	private MemoPompier auTravail;
	private MemoPompier disponible;
	
	public Periode(Date pDate, int pTranche)
	{
		laDate = pDate;
		laTranche = pTranche;
		enMission = new MemoPompier();
		auTravail = new MemoPompier();
		disponible = new MemoPompier();
	}
	
	public MemoPompier getEnMission() {
		return enMission;
	}

	public MemoPompier getAuTravail() {
		return auTravail;
	}

	public MemoPompier getDisponible() {
		return disponible;
	}

	public String  getStatut(Pompier unPompier)
	{
		String statut= "|| ";
		if(enMission.contient(unPompier) == true)
			statut += "Statut : En mission";
		else if(auTravail.contient(unPompier) == true)
			statut += "Statut : Au travail";
		else if(disponible.contient(unPompier) == true)
			statut += "Statut : Disponible";
		return statut;
	}
	
	public void missionner(Pompier unPompier)
	{
		boolean statementOfRemove;
		statementOfRemove = auTravail.extraire(unPompier);
		if (statementOfRemove == false)
			disponible.extraire(unPompier);
		enMission.add(unPompier);
	}
	

	public MemoPompier selectEquipe(int nbPompier)
	{
		MemoPompier tEquipe = new MemoPompier();
		for (Pompier pPompier : enMission.getListePompier())
			tEquipe.add(pPompier);
		for (Pompier pPompier : disponible.getListePompier())
			tEquipe.add(pPompier);
		for (Pompier pPompier : auTravail.getListePompier())
			tEquipe.add(pPompier);

		if (tEquipe.getListePompier().size() - 1 < nbPompier)
			nbPompier = tEquipe.getListePompier().size();

		MemoPompier tEquipeDefinie = new MemoPompier();
		for (int i = 0; i < nbPompier; i++)
			tEquipeDefinie.add(tEquipe.get(i));

		return tEquipeDefinie;
	}

	
	public void vider()
	{
		enMission.vider();
		auTravail.vider();
		disponible.vider();
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yy");
		return "Periode : " + formater.format(laDate) + " laTranche  " + laTranche ;
	}
	
	
	

}
