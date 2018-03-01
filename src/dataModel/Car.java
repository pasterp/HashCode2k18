package dataModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Car {
	int id, nextAvailable;
	public List<Ride> rides;
	public Position pos;
	
	public Car(int id) {
		this.id = id;
		nextAvailable = 0;
		rides = new ArrayList<>();

    pos = new Position(0,0);
	}
	
	public boolean isAvailable(int currentStep) {
		if(currentStep < this.nextAvailable) {
			return false;
		}else {
			return true;
		}
	}
	
	public int distanceToRide(Ride goal) {
		return goal.start.distance(pos);
	}
	
	public boolean rideIsPossible(int currentStep, Ride goal) {
		int total = this.distanceToRide(goal);
		total += goal.start.distance(goal.finish);
		return total < goal.latest;
	}
	

}
