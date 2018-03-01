package dataModel;

public class Ride implements Comparable {
	public Position start, finish;
	public int id, earliest, latest;

	public int getDistance() {
		return Math.abs(start.x - finish.x) + Math.abs(start.y - finish.y);
	}

	@Override
	public int compareTo(Object compareRide) {
		int compareId = ((Ride) compareRide).id;
		/* For Ascending order */
		return this.id - compareId;
	}
}
