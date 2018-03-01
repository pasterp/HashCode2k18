import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataModel.Simulation;

public class William {

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = {"a_example.in","b_should_be_easy.in","c_no_hurry.in","d_metropolis.in","e_high_bonus.in"};		
		Simulation sim = new Simulation();
		
		for(String file : files) {
			Parser parser = new Parser(file, sim);

			parser.sim.resolveV1();
			
			parser.sim.printOutputToFile(file+".out");

		}
		
	}

}
