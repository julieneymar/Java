package mysql;
import java.sql.*;


public class mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.jdbc.Driver");   // charger le driver de mysql
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sqldatabase", "root","");   // creer la connexioin
			
			Statement st = con.createStatement();     // creer un etat de conexion
			
			ResultSet res = st.executeQuery("Select * from Student");     // creer une requete de selection
			// parcours des données
			while (res.next())
			{
				System.out.println("NOM :" + res.getString(2) + "  Email :" + res.getString(3));
				System.out.println("---------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
