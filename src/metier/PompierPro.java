package metier;

public class PompierPro extends Pompier{

    private String grade;
    public PompierPro(String nom, String prenom, int numeroBip, String pGrade) {
        super(nom, prenom, numeroBip);
        grade = pGrade;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " || Numero de bip : " + numeroBip + " || Son grade : " + grade;
    }
}
