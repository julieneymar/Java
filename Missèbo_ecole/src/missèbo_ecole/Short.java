package missèbo_ecole;


public class Short extends Article {

	public Short() {
		this.nom="Short neutre";
		this.categorie="Short";
		this.description="";
		this.prix=2500;
		this.prixMin=1000;
		this.qte=1;
		this.espace=0.1;
		this.taille=30;
	}

	public Short(String nom, String desc, int p1, int p2, int qty, int taille) {
		super(nom, "Short", desc, p1, p2, qty, 0.1);

		taille=Math.min(60, Math.max(20, Math.abs(taille)));
		this.taille=taille;
	}

	public Short(String n, int prix, int taille) {
		super(n, "Short", prix);
		this.espace=0.1;
		
		taille=Math.min(60, Math.max(20, Math.abs(taille)));
		this.taille=taille;
	}

	public Short(Short original) {
		super(original);
		this.taille=original.taille;
	}

	//Accesseurs
	public int getTaille() {
		return taille;
	}

	//Mutateurs
	public void setTaille(int taille) {
		taille=Math.min(60, Math.max(20, Math.abs(taille)));
		this.taille=taille;
	}

	public String afficher() {
		String texte = super.afficher();
		texte+=" Taille: "+taille+".";
		return texte;
	}

	//Attributs
	private int taille;
}
