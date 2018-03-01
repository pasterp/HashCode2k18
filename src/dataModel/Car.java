package dataModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Car {
	int id, nextAvailable;
	public List<Ride> rides;
	public Position pos;

	public Car(int id, int nbMaxSteps) {
		this.id = id;
		nextAvailable = 0;
		rides = new LinkedList<>();
		pos = new Position(0, 0);
	}

	public boolean isAvailable(int currentStep) {
		if (currentStep < this.nextAvailable) {
			return false;
		} else {
			return true;
		}
	}

	public int distanceToRide(Ride goal) {
		return goal.start.distance(pos);
	}

	public int endTimeRide(int currentStep, Ride ride) {
		return this.distanceToRide(ride) + ride.start.distance(ride.finish);
	}

	public boolean rideIsPossible(int currentStep, Ride goal) {
		int total = endTimeRide(currentStep, goal);
		return total <= goal.latest;
	}

}
