package principal;


import java.util.Date;

import bd.BasesDonnees;
import Stockage.MemoPompier;
import metier.*;

public class main {

	public static void main(String[] args) {
	
		Pompier p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
		p1 = new Pompier("Vermissel",  "Jojo", 1);
		p2 = new Pompier("Bambin",  "Fernand", 2);
		p3 = new Pompier("Demoulin",  "Robert", 3);
		p4 = new Pompier("Dupin",  "Philippe", 4);
		p5 = new Pompier("Lestier",  "Reymond", 5);
		p6 = new Pompier("Artaud",  "Kevin", 6);
		p7 = new Pompier("Parme",  "Remi",7);
		p8 = new Pompier("Fistier",  "Romain", 8);
		p9 = new Pompier("Imbert",  "Titeuf", 9);
		p10 = new Pompier("Darmon",  "Monique", 10);
		
		// memorisation dans un objet de stockage
		MemoPompier lesPompiers;
		lesPompiers = new MemoPompier();
		lesPompiers.add(p1);
		lesPompiers.add(p2);
		lesPompiers.add(p3);
		lesPompiers.add(p4);
		lesPompiers.add(p5);
		lesPompiers.add(p6);
		lesPompiers.add(p7);
		lesPompiers.add(p8);
		lesPompiers.add(p9);
		lesPompiers.add(p10);
		
		//afficher les Pompiers contenus dans l'objet lesPompiers
		System.out.println("\n-------------------------------Etape 1---------------------------------");
		System.out.println("Voici la liste des Pompiers :\n");
		System.out.println(lesPompiers.toString());

		System.out.println("\n-------------------------------Etape 2---------------------------------");
		Periode unePeriode = new Periode(new Date(),1);
		System.out.println(unePeriode.toString());

		System.out.println("\n-------------------------------Etape 3---------------------------------");
		Pompier unP;
		MemoPompier disponible, auTravail, enMission ;
		disponible = unePeriode.getDisponible();
		auTravail = unePeriode.getAuTravail();
		enMission = unePeriode.getEnMission();
		disponible.add(p1);
		disponible.add(p2);
		disponible.add(p3);
		disponible.add(p4);
		disponible.add(p5);
		auTravail.add(p6);
		auTravail.add(p7);
		auTravail.add(p8);
		auTravail.add(p9);
		auTravail.add(p10);
		
		System.out.println (" \nsont disponibles  \n");
		for (int i = 0; i < disponible.cardinal();i++)
		{
			unP = disponible.get(i);
			System.out.println(unP.toString() +  " statut " + unePeriode.getStatut(unP).toString()); 
		}
		
		System.out.println (" \nsont au Travail  \n");
		for (int i = 0; i < auTravail.cardinal();i++)
		{
			unP = auTravail.get(i);
			System.out.println(unP.toString() +  " statut " + unePeriode.getStatut(unP).toString()); 
		}
		

		System.out.println("\n-------------------------------Etape 4---------------------------------");
		unePeriode.missionner(p1);
		unePeriode.missionner(p2);
		unePeriode.missionner(p3);
		unePeriode.missionner(p6);
		unePeriode.missionner(p7);
		unePeriode.missionner(p8);
		
		System.out.println (" \nsont disponibles  \n");
		for (int i = 0; i < disponible.cardinal();i++)
		{
			unP = disponible.get(i);
			System.out.println(unP.toString() +  " statut " + unePeriode.getStatut(unP).toString()); 
		}
		
		System.out.println (" \nsont au Travail  \n");
		for (int i = 0; i < auTravail.cardinal();i++)
		{
			unP = auTravail.get(i);
			System.out.println(unP.toString() +  " statut " + unePeriode.getStatut(unP).toString()); 
		}
		
		System.out.println (" \nsont en Mission  \n");
		for (int i = 0; i < enMission.cardinal();i++)
		{
			unP = enMission.get(i);
			System.out.println(unP.toString() +  " statut " + unePeriode.getStatut(unP).toString()); 
		}

		System.out.println("\n-------------------------------Etape 5---------------------------------");
		MemoPompier uneEquipe;
		unePeriode.vider();
		disponible.add(p1);
		disponible.add(p2);
		disponible.add(p3);
		disponible.add(p4);
		disponible.add(p5);
		auTravail.add(p6);
		auTravail.add(p7);
		auTravail.add(p8);
		auTravail.add(p9);
		auTravail.add(p10);
		
		uneEquipe=unePeriode.selectEquipe(3);
		System.out.println(" une equipe de 3");
		System.out.println(uneEquipe.toString());
		uneEquipe=unePeriode.selectEquipe(5);
		System.out.println(" une equipe de 5 ");
		System.out.println(uneEquipe.toString());
		uneEquipe=unePeriode.selectEquipe(8);
		System.out.println(" une equipe de 8 ");
		System.out.println(uneEquipe.toString());
		uneEquipe=unePeriode.selectEquipe(10);
		System.out.println(" une equipe de 10 ");
		System.out.println(uneEquipe.toString());
		uneEquipe=unePeriode.selectEquipe(15);
		System.out.println(" une equipe de 15 ");
		System.out.println(uneEquipe.toString());

		System.out.println("\n-------------------------------Etape 6---------------------------------");
		Caserne uneCaserne;
		uneCaserne = new Caserne();
		PompierVol  unPV;
		unPV = new PompierVol("Tointoin","Noel",11,4);
		PompierPro unPP;
		unPP =new PompierPro("Barnaud","Robert",12,"commandant");
		uneCaserne.addPompier(unPV);;
		uneCaserne.addPompier(unPP);
		System.out.println (uneCaserne.toString());

		System.out.println("\n-------------------------------Etape 7---------------------------------");
		
		BasesDonnees bd = new BasesDonnees();
		bd.affichePompierPro();
		bd.affichePompierVol();

		System.out.println("\n-------------------------------Etape 8---------------------------------");
		System.out.println(bd.getUnMemoPompier().toString());

		
	}

	
}
