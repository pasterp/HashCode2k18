import java.io.FileNotFoundException;
import dataModel.Simulation;

public class William {

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = {"a_example.in","b_should_be_easy.in","c_no_hurry.in","d_metropolis.in","e_high_bonus.in"};		
		Simulation sim = new Simulation();
		
		for(String file : files) {
			Parser parser = new Parser(file, sim);

			parser.sim.resolveV1();
			
			System.out.println(file + " résolu.");
			parser.sim.printOutputToFile(file+".out");

		}
		
	}

}
