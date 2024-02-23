package gestio_etudiant;

import java.util.Scanner;

public class etudiant
{
	// Attribut
	private String nom, prenom;
	private double [] note;
	private double moyenne;
	
	//costructeurs
	
	public etudiant() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("entrer le nom de l'etudian : ");
		this.nom = sc.next();
		System.out.println("le nom de l'etudaint est :" + nom);
		System.out.println("entrer le prénom de l'etudian : ");
		this.prenom = sc.next();
		System.out.println("le prenom de l'etudaint est :" + prenom);
		System.out.println("L'etudiant possède combien de notes: ");
		int nt = sc.nextInt();
		System.out.println("l'etudiant " + nom +" " + prenom + " possède " + nt + " notes");
		
	}
	

}
