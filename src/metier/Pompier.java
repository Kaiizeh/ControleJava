package metier;

public class Pompier {
	protected String nom;
	protected String prenom;
	protected int numeroBip;
	
	
	public Pompier(String nom, String prenom, int numeroBip) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroBip = numeroBip;
	}

	public int getNumeroBip() {
		return numeroBip;
	}

	public void missionner(Periode unePeriode)
	{
		unePeriode.missionner(this);
	}

	
	@Override
	public String toString() {
		return nom + " " + prenom + " || Numero de bip : " + numeroBip ;
	}
}
