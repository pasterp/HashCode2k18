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
	
	
	public void resolve() {
		Car c;
		for(Ride r : rides) {
			c = this.getBestCarForRide(r);
			if(c != null) {
				rides.remove(r);
				c.rides.add(r);
				c.nextAvailable = c.endTimeRide(currentStep, r);
				c.pos = r.finish;
			}
		}
			
	}
	
	public Car getBestCarForRide(Ride ride) {
		Car tmpCar;
		int[] choice = new int[cars.size()];
		for(int i = 0; i< cars.size(); i++) {
			tmpCar = cars.get(i);
			choice[i] = algoImportant(tmpCar, ride);
		}
		
		tmpCar = cars.get(0);
		int tmp = 0;
		
		for(int i = 0; i< choice.length; i++) {
			if(tmp < choice[i]) {
				tmpCar = cars.get(i);
				tmp = choice[i];
			}
		}
		if(tmp == -1) {
			return null;
		}
		return tmpCar;
	}
	
	public int algoImportant(Car c, Ride r) {
		if(!c.rideIsPossible(c.nextAvailable, r)) {
			return -1;
		}
		
		int total = 0;
		if(r.earliest == (c.distanceToRide(r)+ c.nextAvailable)) {//chope bonus
			total += bonus;
		}		

		return 0;
	}
}
