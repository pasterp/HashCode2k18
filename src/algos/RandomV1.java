package algos;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

import dataModel.Car;
import dataModel.Parser;
import dataModel.Ride;
import dataModel.Simulation;

public class RandomV1 {

	public Simulation sim;
	
	public static void main(String[] args) throws FileNotFoundException {
		String[] files = {"a_example.in","b_should_be_easy.in","c_no_hurry.in","d_metropolis.in","e_high_bonus.in"};		
		Simulation sim = new Simulation();
		
		for(String file : files) {
			Parser parser = new Parser(file, sim);

			parser.sim.resolveV1();
			
			parser.sim.printOutputToFile(file+".out");
			
		}
		
	}
	
	public RandomV1(Simulation sim) {
		this.sim = sim;
	}

	public void simulate() {
		int carId = 0;
		while (!sim.rides.isEmpty()) {

			Ride r = sim.rides.remove(new Random().nextInt(sim.rides.size()));
			sim.cars.get(carId).rides.add(r);

			carId++;
			if (carId > sim.nbVehicules) {
				carId = 0;
			}
		}

	}

	public void printOutputToFile(String filename) throws FileNotFoundException {
		PrintStream out = new PrintStream(filename);

		for (Car c : sim.cars) {
			out.print(c.rides.size() + " ");
			for (Ride r : c.rides) {
				out.print(r.id + " ");
			}
			out.println();
		}

		out.close();
	}

}
