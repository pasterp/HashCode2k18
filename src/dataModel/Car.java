package dataModel;

import java.util.LinkedList;
import java.util.List;

public class Car {
	int id;
	public List<Ride> rides;
	public Position pos;
	
	public Car(int id) {
		this.id = id;
		rides = new LinkedList<>();
		pos = new Position(0,0);
	}
}
