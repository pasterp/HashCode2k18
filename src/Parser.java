import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import dataModel.Simulation;

public class Parser {

	Simulation sim;
	Scanner s ;
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
		sim.rides = new ArrayList<>(nbRides);
		
		/** DATA **/
		l=s.nextLine();
		params = l.split(" ");
		
		s.close();
	}

}
