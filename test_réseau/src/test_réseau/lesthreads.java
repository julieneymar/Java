package test_réseau;

import java.io.*;

public class lesthreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File(".");
		File[] arr = dir.listFiles(new FilenameFilter() 
		{

			@Override
			public boolean accept(File arg0, String arg1) {
				// TODO Auto-generated method stub
				if (arg1.endsWith(".java"))
					return true;
				else
					return false;
			}
			
		});
		
		for (File fichier )

	}

}
