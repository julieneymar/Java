package les_essais;

import java.util.Scanner;

public class personne {
	
	int age;
	String nom, prenom , sex;
	boolean d ;
	Scanner sc = new Scanner(System.in);
	
	public personne () 
	{
		this.age = age;
		this.nom = nom;
		this.sex = sex;
		this.d = d ;
				}
	public void afficher () 
	{		
		System.out.println("entre votre age :" );
		int age = sc.nextInt();
		System.out.println( age);
		System.out.println("entre votre nom :" );
		String nom = sc.next();
		System.out.println( nom);
		System.out.println("entre votre sex :" );
		String sex = sc .next();
		System.out.println( sex);
		System.out.println( d);
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		personne x ,v; personne deo = new personne(); personne t = new personne();
		deo.afficher();
		
	}

}
