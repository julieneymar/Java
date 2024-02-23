/*package gestion_eleves;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionClient
{
	Connection cn;
	
	public connectionClient () 
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		cn = (connetion) DriverManager.getConnection("jdbc:mysql;//localhost/livre", "root", "");
		System.out.println("connection Etablir");
		} catch (Exception e) 
		{
			System.out.println("Erreu de connection ");
			e.printStackTrace();	
		}	
	}
	public connectionClient maConnection()
	{
		return (connectionClient) cn;
	}
}
*/