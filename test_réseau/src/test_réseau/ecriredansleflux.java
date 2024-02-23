package test_réseau;

import java.io.*;
import java.math.BigInteger;

public class ecriredansleflux {
	
	static void ecrisDansleFlux (FileOutputStream fos) throws Exception 
	{
		for(int cc = 33; cc<127; cc++) 
		{
			fos.write(cc);
		} 
		//atresFonction
		
		for(int cc = 33;cc<127;cc++)
		{
			byte[] arr = BigInteger.valueOf(cc).toByteArray();
			if(arr.length>1) 
			{
				//.....
			}
			fos.write(arr);
		}
	}

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method 
		
		FileOutputStream fos = new FileOutputStream("exemple.date");
		ecrisDansleFlux(fos);
		
		fos.close();

	}

}
