import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class William {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputFile = new Scanner(new File("small.in"), "UTF-8");
		
		String l1 = inputFile.nextLine();
		String[] params = l1.split(" ");

		inputFile.close();

	}

}
