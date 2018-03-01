import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class William {

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = {"a_example.in","b_should_be_easy.in","c_no_hurry.in","d_metropolis.in","e_high_bonus.in"};
		Scanner inputFile = new Scanner(new File(files[0]), "UTF-8");
		
		String l1 = inputFile.nextLine();
		String[] params = l1.split(" ");

		inputFile.close();

	}

}
