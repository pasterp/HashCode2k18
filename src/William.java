import java.io.FileNotFoundException;

import dataModel.Parser;
import dataModel.Simulation;

public class William {

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = {"a_example.in","b_should_be_easy.in","c_no_hurry.in","d_metropolis.in","e_high_bonus.in"};		
		
		for(String file : files) {
			Simulation sim = new Simulation();
			Parser parser = new Parser(file, sim);

			parser.sim.resolve();
			
			System.out.println(file + " résolu.");
			parser.sim.printOutputToFile(file+".out");
			
		}
		
	}

}
