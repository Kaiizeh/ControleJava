package metier;

public class PompierVol extends Pompier{

    private int niveauDeFormation;
    public PompierVol(String nom, String prenom, int numeroBip, int pLvl) {
        super(nom, prenom, numeroBip);
        niveauDeFormation = pLvl;
    }

    public String toString() {
        return nom + " " + prenom + " || Numero de bip : " + numeroBip + " || Son niveau de formation : " + niveauDeFormation;
    }
}
