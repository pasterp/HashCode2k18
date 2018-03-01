package dataModel;

public class Ride {
	public Position start, finish;
	public int id, earliest, latest;

	public int getDistance() {
		return Math.abs(start.x - finish.x) +Math.abs(start.y - finish.y);
	}
}
