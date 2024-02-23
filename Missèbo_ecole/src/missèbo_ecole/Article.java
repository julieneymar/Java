package missèbo_ecole;
public class Article {
	//Constructeurs
	public Article() {
		this.nom="Habit";
		this.categorie="Tenue";
		this.description="";
		this.prix=2000;
		this.prixMin=500;
		this.qte=1;
		this.espace=1;
	}
	
	public Article(
			String nom, String cat,
			String desc, int p1, int p2,
			int qty,
			double space) {
		this.nom=nom.trim();
		this.categorie=cat.trim();
		this.description=desc.trim();

		p1=Math.abs(p1);
		p2=Math.abs(p2);
		this.prix=Math.max(p1, p2);
		this.prixMin=Math.min(p1, p2);
		
		this.qte=Math.abs(qty);
		this.espace=Math.max(Math.abs(space),0.01);
	}
	
	public Article(
			String n, String cat, int prix) {
		this.nom=n.trim();
		this.categorie=cat.trim();
		this.description="";
		this.prix=Math.abs(prix);
		this.prixMin=Math.abs(prix);
		this.qte=1;
		this.espace=1;
		
	}
	
	public Article(Article original) {
		this.nom=original.nom;
		this.categorie=original.categorie;
		this.description=original.description;
		this.prix=original.prix;
		this.prixMin=original.prixMin;
		this.qte=original.qte;
		this.espace=original.espace;		
	}
	
	
	//Accesseurs
	public String getNom() {
		return nom;
	}
	
	public String getCategorie() {
		return categorie;
	}

	public String getDescription() {
		return description;
	}

	public int getPrix() {
		return prix;
	}

	public int getPrixMin() {
		return prixMin;
	}

	public int getQte() {
		return qte;
	}

	public double getEspace() {
		return espace;
	}

	//Mutateurs
	public void setNom(String n) {
		this.nom=n.trim();
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie.trim();
	}

	public void setDescription(String description) {
		this.description = description.trim();
	}

	public void setPrix(int prix) {
		prix=Math.abs(prix);
		this.prix = Math.max(prix, this.prixMin);
	}

	public void setPrixMin(int prixMin) {
		prixMin=Math.abs(prixMin);
		
		int diff = prixMin - this.prixMin;
		if(diff>0)
			this.prix+=diff;
		this.prixMin = prixMin;
	}

	public void setQte(int qte) {
		this.qte = Math.abs(qte);
	}

	public void setEspace(double espace) {
		this.espace = Math.max(Math.abs(espace),0.01);
	}
	
	//Methodes
	public int acheter(int n) {
		qte+=Math.abs(n);
		return qte;		
	}
	
	public Article vendre(int n) {
		n=Math.abs(n);
		n=Math.min(n, qte);
		qte-=n;
		Article paquet = new Article(this);
		paquet.setQte(n);
		return paquet;
	}
	
	public double espaceTotal() {
		return espace * qte;		
	}
	
	public int prixTotal() {
		return prix * qte;
	}
	
	public String afficher() {
		String texte = "";
		texte+=nom;
		texte+=" ("+ categorie +")";
		
		if(description.isEmpty())
			texte+=". ";
		else
			texte+=": " + description + ". ";
		
		texte+="Prix de vente: " +prix + "FCFA";
		
		if(prix==prixMin)
			texte+=" (Non n�gociable). ";
		else
			texte+=" � d�battre (Dernier prix: "+prixMin +"FCFA). ";

		if(qte==0)
			texte+="En rupture de stock. ";
		else if(qte==1)
			texte+=qte + " unit� en stock. ";
		else
			texte+=qte + " unit�s en stock. ";
		
		texte+=espace +" cartons.";
		return texte;
	}
	
	//Attributs
	protected String nom;
	protected String categorie;
	protected String description;
	
	protected int prix;
	protected int prixMin;
	
	protected int qte;
	protected double espace;
}
