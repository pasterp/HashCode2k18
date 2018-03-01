package dataModel;

public class Ride implements Comparable {
	public Position start, finish;
	public int id, earliest, latest;

	public int getDistance() {
		return Math.abs(start.x - finish.x) + Math.abs(start.y - finish.y);
	}

	@Override
	public int compareTo(Object compareRide) {
		int compareEarliest = ((Ride) compareRide).earliest;
		/* For Ascending order */
		return this.earliest - compareEarliest;
	}
}
