package hangmangamecodin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		// créaction de l'objet fichier de la classe "File" avec root du fichier
		System.out.println("welcome to game");
		File dictionary = new File ("C:/Users/Goku/eclipse-workspace/hangmangamecodin/src/hangmangamecodin/engmix.txt");
		Scanner textscanner = new Scanner(dictionary); // créaction d'un scanner dans le dictionnaire pour lire les mots à l'intérieur
		Scanner input = new Scanner (System.in); // creaction d'un scanner dans le systeme pour lire les lettre de user
		ArrayList <String> words = new ArrayList <>(); //créaction d'une liste d'attente pour call les mots du dictionnaire 
		
		while (textscanner.hasNextLine())  // parcourir les mots du dico en lisant chaque fois à la ligne
		{
			words.add(textscanner.nextLine());  // ajout de chaque mot lire à la liste.
		}
		String hidden_text = words.get((int)(Math.random()* words.size()) );
		char [] textArray = hidden_text.toCharArray(); // tochararray permet de convertir la chaine en tableaux de chaine,tableau du mot cache
		char [] myAnswer = new char [textArray.length]; // table de reponse du meme taille que le precedent
		for (int i = 0; i < textArray.length; i++) // boocle pour les lettre
		{
			myAnswer [i] = '?';
		}
		boolean finished = false; 
		int lives = 6;
		while (finished == false) // boucle pour le jeu,tna que finishe est faux le jeu continue
		{
			System.out.println("****************");
			String letter = input.next();
			// check for valid imput
			while (letter.length() != 1 || Character.isDigit(letter.charAt(0)))
			{
				System.out.println("error Input - try again ");
				letter = input.next();
			}
			// chack if letter is in the word
			boolean found = false;
			for  ( int i = 0; i< textArray.length; i++)
			{
				if (letter.charAt(0) == textArray[i])
				{
					myAnswer[i] = textArray[i];
					found = true;
				}
			}
			if (!found)
			{
				lives--;
				System.out.println("wrong letter");
			}
			boolean done = true;
			for (int i = 0; i < myAnswer.length; i++ )
			{
				if (myAnswer[i] == '?')
				{
					System.out.print(" _ ");
					done = false;
				}
				else 
				{
					System.out.print(" " + myAnswer[i]);
				}
			}
			System.out.println("\n" + "lives left: " + lives);
			drawHangman(lives);
			// check if the game end
			if (done ) 
			{
				System.out.println("congrats you found the word");
				finished = true;	
			}
			if (lives <= 0) 
			{
				System.out.println("you are dead ! study your inglish");
				finished = true;			
			}
			
		}
		System.out.println(hidden_text);
			
		}
		public static void drawHangman(int l)
		{
			  if(l == 6) {
			   System.out.println("|----------");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 5) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 4) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|    |");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 3) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 2) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 1) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|   /");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else{
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|   /|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			 }
		

}
