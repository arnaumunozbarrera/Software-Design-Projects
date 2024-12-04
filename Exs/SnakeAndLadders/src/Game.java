import java.util.LinkedList;

public final class Game {
	private LinkedList<Player> players = new LinkedList<Player>();
	private Board board = null;
	private Player winner;

	public Game(String[] playerNames, int numSquares, int[][] toFrom, int[] deathSquares) {

		makeBoard(numSquares, toFrom, deathSquares);
		makePlayers(playerNames);
	}

	public void play() {
		assert !players.isEmpty() : "No players to play";
		assert board!=null : "No scoreboard to play";

		Die die = new Die();
		initializeGame();

		System.out.println("Initial state : \n" + this);
		int numRounds = 0;

		while (notOver()) {
			int roll = die.roll();
			System.out.println("Current player is " + currentPlayer() + " and rolls " + roll);
			movePlayer(roll);
			System.out.println("State : \n" + this);
			numRounds++;
		}
		if (currentPlayer()==null) {
			System.out.println( " Everyone dead ");
		} else {
			System.out.println(winner + " has won after " + numRounds + " rounds");
		}
	}

	private void makeBoard(int numSquares, int[][] toFrom, int[] deathSquares) {
		board = new Board(numSquares, toFrom, deathSquares);
	}

	private void makePlayers(String[] playerNames) {
		assert playerNames.length>0 : "There must be some player" ;
		System.out.println("Players are : ");
		int i=1;
		for (String str : playerNames) {
			Player player = new Player(str);
			players.add(player);
			System.out.println(i + ". " + str);
			i++;
		}
	}

	private void initializeGame() {
		placePlayersAtFirstSquare();
		winner = null;
	}

	private void placePlayersAtFirstSquare() {
		for (Player player : players) {
			board.firstSquare().enter(player);
		}
	}

	private boolean PlayerAlive(){
		for(Player p : players){
			if(!p.isDead()){
				return true;
			}
		}
		return false;
	}

	private boolean notOver() {
		return (winner == null) && (PlayerAlive());
	}

	private void movePlayer(int roll) {
		Player currentPlayer = players.remove(); // the first element of the list
		currentPlayer.moveForward(roll);

		if (!currentPlayer.isDead()){
			players.add(currentPlayer);
			if (currentPlayer.wins()) {
				winner = currentPlayer;
			}// to the end of list, we're using the linked list as a queue
		} else {
			System.out.println(currentPlayer + " died");
		}
	}

	@Override
	public String toString() {
		String str = new String();
		for (Player player : players) {
			str += player.getName() + " is at square " + (player.getPosition()+1) + "\n";
		}
		return str;
	}

	private Player currentPlayer() {
		assert players.size()>0;
		return players.peek();
	}
}
