package dataModel;

public class Ride implements Comparable {
	public Position start, finish;
	public int id, earliest, latest, nextAvalaible;
	

	public Ride(int id, int x1, int y1, int x2, int y2, int earliest, int latest) {

		this.id = id;
		start = new Position(x1, y1);
		finish = new Position(x2, y2);
		this.earliest = earliest;
		this.latest = latest;
	}

	public int getDistance() {
		return Math.abs(start.x - finish.x) + Math.abs(start.y - finish.y);

	}

	@Override
	public int compareTo(Object compareRide) {
		int compareEarliest = ((Ride) compareRide).earliest;
		/* For Ascending order */
		return this.earliest - compareEarliest;
	}
	
	public boolean isAvailable(int currentStep) {
		if(currentStep < this.nextAvalaible) {
			return false;
		}else {
			return true;
		}
	}
}
