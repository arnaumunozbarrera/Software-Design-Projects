import java.util.ArrayList;

public class FirstSquare extends Square {
	private ArrayList<Player> players = new ArrayList<Player>();

	public FirstSquare(Board b) {
		super(0, b);
	}

	@Override
	public void enter(Player p) {
		players.add(p);
		p.setSquare(this);
	}

	@Override
	public void leave(Player p) {
		players.remove(p);
	}

	@Override
	public boolean isOccupied() {
		return !players.isEmpty();
	}
}
