package les_essais;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.IOException;




public class write {

	public static void main(String[] args) 
	{
		Path f = Paths.get("C://Users/Goku/eclipse-workspace/les_essais/src/les_essais/file.txt");
		try
		{
			BufferedWriter bfw = Files.newBufferedWriter(f);
			bfw.write("bonjour");
			bfw.close();
		}
			
		catch (IOException e)
		{
			System.out.println("IOException:" + e.getMessage());
		}
		
	}
}

