package missèbo_ecole;


public class Acheteur extends Personne {

	public Acheteur() {
		// TODO Auto-generated constructor stub
	}

	public Acheteur(String n, char g, String nat, int a, int c) {
		super(n, g, nat, a, c);
		// TODO Auto-generated constructor stub
	}

	public Acheteur(String n, char g, int c) {
		super(n, g, c);
		// TODO Auto-generated constructor stub
	}

	public Acheteur(Personne jumeau) {
		super(jumeau);
		// TODO Auto-generated constructor stub
	}

	protected String tailleHaut;
	protected int tailleBas;
	protected int pointure;
}
