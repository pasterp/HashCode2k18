package dataModel;

public class Ride {
	public Position start, finish;
	public int id, earliest, latest, nextAvalaible;
	

	public int getDistance() {
		return Math.abs(start.x - finish.x) +Math.abs(start.y - finish.y);
	}
	
	public boolean isAvailable(int currentStep) {
		if(currentStep < this.nextAvalaible) {
			return false;
		}else {
			return true;
		}
	}
}
