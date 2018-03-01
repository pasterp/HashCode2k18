package dataModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Car {
	int id, nextAvailable;
	public List<Ride> rides;
	public Position pos;
	public Position[] planning;

	public Car(int id, int nbMaxSteps) {
		this.id = id;
		nextAvailable = 0;
		rides = new LinkedList<>();
		pos = new Position(0, 0);
		planning = new Position[nbMaxSteps];
		for (int i = 0; i < nbMaxSteps; i++) {
			planning[i] = null;
		}
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

	// Check available from start to end
	public boolean isFreeBetween(int start, int end) {
		for (int i = start; i <= end; i++) {
			if (planning[i] != null) {
				return false;
			}
		}
		return true;
	}

	public void setUnavailable(int from, int to, Position position) {
		for (int i = from; i <= to; i++) {
			planning[i] = position;
		}
	}

}
