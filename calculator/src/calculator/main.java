package calculator;

import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner cs = new Scanner(System.in);
		calculator calculatrice = new calculator(0, 0);
		System.out.println("Bienvenus dans le calculatrice");
		System.out.println("1-Addition");
		System.out.println("2-Soustraction");
		System.out.println("3-Multiplication");
		System.out.println("4-Division");
		System.out.println("Choisissez l'opération :");
		double op = cs.nextDouble();
		if ( op == 1 ) 
		{
			System.out.println("ADDITION");
			calculatrice.Addition(5, 8);
		}
			
		else if (op == 2) 
		{
			System.out.println("SOUSTRACTION");
			calculatrice.Soustraction(op, op);
		}
		else if (op == 3)
		{
			System.out.println("MULTIPLICATION");
			calculatrice.Multiplication(op, op);
		}
		else if (op == 4) 
		{
			System.out.println("DIVISION");
			calculatrice.Division(op, op);

		}
			
		cs.close();
	}
	

}
