package test_réseau;

import java.io.*;

public class flux {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream ("exemple.dte");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ecriredansleFlux(bos);
		bos.close();
		
		
		
		FileOutputStream fos2 = new FileOutputStream ("exemple.dte");
		BufferedOutputStream bos2 = new BufferedOutputStream(fos2);
		DataOutputStream dos = new DataOutputStream(bos2);
		ecriredansleFlux(dos);
		dos.close();

	}

	private static void ecriredansleFlux(DataOutputStream fos) throws IOException {
		
		fos.writeDouble(7866677.767);

	}
		private static void ecriredansleFlux(OutputStream fos) throws IOException {
				
				byte b=4;
				long tp0 = System.currentTimeMillis();
				for(int i=0;i<100000;i++) 
				{
					fos.write(b);
				}
				long tp1 = System.currentTimeMillis();
				System.out.println("Temps mis pour exécuter: " + (tp1 - tp0));
				
		
			}
	
	

}
