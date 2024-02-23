package les_essais;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;




public class fichiers {

	public static void main(String[] args) 
	{
		Path f = Paths.get("C://Users/Goku/eclipse-workspace/les_essais/src/les_essais/file.txt");
		try
		{
			BufferedReader bfr = Files.newBufferedReader(f);
			System.out.println(bfr.readLine() );
			bfr.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException:" + e.getMessage());
		}
		
		finally
		{
		
		}

	}

}
