package dataModel;

import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.List;

public class Simulation {
	public int currentStep;
	public int rows, columns, nbVehicules, nbRides, bonus, nbMaxSteps;
	public List<Car> cars;
	public List<Ride> rides;

	// Sort rides by ascending id
	public void sortRidesByStartingTime() {
		Collections.sort(rides);
	}

	public void printOutput() {
		for (Car c : cars) {
			System.out.print(c.rides.size() + " ");
			for (Ride r : c.rides) {
				System.out.print(r.id + " ");
			}
			System.out.println();
		}
	}

	public void printOutputToFile(String filename) throws FileNotFoundException {
		PrintStream out = new PrintStream(filename);

		for (Car c : cars) {
			out.print(c.rides.size() + " ");
			for (Ride r : c.rides) {
				out.print(r.id + " ");
			}
			out.println();
		}

		out.close();
	}
}
