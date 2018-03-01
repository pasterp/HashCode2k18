package dataModel;

import java.util.ArrayList;
import java.util.List;

public class Car {
	int id;
	public List<Ride> rides;
	public Position pos;
	
	public Car(int id) {
		this.id = id;
		rides = new ArrayList<>();
		pos = new Position(0,0);
	}
}
