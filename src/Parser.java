import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataModel.Car;
import dataModel.Ride;
import dataModel.Simulation;

public class Parser {

	Simulation sim;
	Scanner s;

	public Parser(String inputFile, Simulation sim) throws FileNotFoundException {
		s = new Scanner(new File(inputFile), "UTF-8");
		this.sim = sim;
		parse();
	}

	private void parse() {

		/** PARAMS **/
		String l = s.nextLine();
		String[] params = l.split(" ");

		int rows, cols, nbVehicules, nbRides, bonus, nbMaxStep;
		rows = Integer.parseInt(params[0]);
		cols = Integer.parseInt(params[1]);
		nbVehicules = Integer.parseInt(params[2]);
		nbRides = Integer.parseInt(params[3]);
		bonus = Integer.parseInt(params[4]);
		nbMaxStep = Integer.parseInt(params[5]);

		sim.rows = rows;
		sim.columns = cols;
		sim.nbVehicules = nbVehicules;
		sim.nbRides = nbRides;
		sim.bonus = bonus;
		sim.nbMaxSteps = nbMaxStep;

		sim.cars = new ArrayList<>(nbVehicules);
		for (int i = 0; i < nbVehicules; i++) {
			sim.cars.add(new Car(i));
		}

		/** DATA **/
		sim.rides = new ArrayList<>(nbRides);
		for (int i = 0; i < nbRides; i++) {
			l = s.nextLine();
			params = l.split(" ");
			int x1, y1, x2, y2, earliest, latest;
			x1 = Integer.parseInt(params[0]);
			y1 = Integer.parseInt(params[1]);
			x2 = Integer.parseInt(params[2]);
			y2 = Integer.parseInt(params[3]);
			earliest = Integer.parseInt(params[4]);
			latest = Integer.parseInt(params[5]);

			sim.rides.add(new Ride(i, x1, y1, x2, y2, earliest, latest));
		}

		s.close();
	}

}
