package test_réseau;

import java.io.File;

import java.net.*;

public class lesurls {
	
	public static void testerUrl (String URL) 
	{
		try {
			URL uneUrl = new URL (URL);
			System.out.println("protocol supporter " + uneUrl.getProtocol());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur sur cette url");
		}
		
	}

	public static void main(String[] args) throws MalformedURLException 
	{
		// TODO Auto-generated method stub
		
	testerUrl("https://www.facebook.com/");
	testerUrl("file:///C:/Users/Goku/Documents/licence2/electronic%20num%C3%A9rique/Electronique/Electronique/Annexes_Informations%20sur%20les%20Applications/Applications%20des%20syst%C3%A8mes%20num%C3%A9riques.pdf");
	testerUrl("C://Users//Goku//eclipse-workspace//test_réseau");
	testerUrl("https://www.youtube.com/");
	testerUrl("https://mail.google.com/");
	
	File t = new File ("tony");
	URL ici = t.toURL();
	System.out.println("ici : " + ici);
	


		

	}

}
