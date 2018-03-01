package dataModel;

public class Position {
	public int x, y;
	
	public Position(int i, int j) {
		x = i;
		y = j;
	}
	
	public int distance(Position destination) {
		return Math.abs(destination.x - x) + Math.abs(destination.y - y);
  }
}
