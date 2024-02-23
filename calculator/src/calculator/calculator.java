package calculator;

import java.util.Scanner;

public class calculator 
{
	// ATTIBUTS
	protected double num1;
	protected double num2;
	protected double res;
	Scanner sc = new Scanner(System.in);
	
	
	
	
	
	//CONSTRUCTEURS
	public  calculator(double num1, double num2)
	{
		this.num1 = 0;
		this.num2 = 0;
		this.res = 0;
		return ;
	}
	
	
	
	public double getNum1() {
		return num1;
	}



	public void setNum1(double num1) {
		this.num1 = num1;
	}
	
	public double getres () 
	{
		return res;
	}

	public void setres( double res) 
	{
		this.res = res;
	}



	public double getNum2() {
		return num2;
	}



	public void setNum2(double num2) {
		this.num2 = num2;
	}



	public Scanner getSc() {
		return sc;
	}


																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
	public void setSc(Scanner sc) {
		this.sc = sc;
	}



	//METHODE
	public double Addition(double num1, double num2)
	{
		
		//num1 = sc.nextDouble();
		//num2 = sc.nextDouble();
		res =  num1+num2;
		System.out.println(res);
		return res;
		
		
	}
	
	public double Soustraction(double num1, double num2) 
	{
		//num1 = sc.nextDouble();
		//num2 = sc.nextDouble();
		res = num1-num2;
		System.out.println(res);
		return res ;
		 
		
	}
	
	public double Multiplication (double num1, double num2) 
	{
		//num1 = sc.nextDouble();
		//num2 = sc.nextDouble();
		res = num1*num2;
		System.out.println(res);
		return res;
		
	}
	public double Division (double num1, double num2) 
	{
		//num1 = sc.nextDouble();
		//num2 = sc.nextDouble();
		res = num1/num2;
		System.out.println(res);
		return res;
	}
	

	
	
	

}
