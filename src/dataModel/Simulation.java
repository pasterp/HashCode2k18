package dataModel;

import java.util.Collections;
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
}
