public class Main {
	private static final String[] PLAYER_NAMES = {"Ana", "Blanca", "Carles", "Didac"};
	// For the user first square is at position 1 but internally is at 0. When defining
	// ladders and snakes from-to squares, we use users positions, 1...numSquares, and
	// when making them we subtract 1 to the position.
	// This is the board of figure 1(a) in the document "example"
	//private static final int numSquares = 36;
	//private static final int[][] snakesFromTo = { {12,2}, {14,11}, {35,22}, {31,19}, {17,4} };
	//private static final int[][] laddersFromTo = { {3,16} , {5,7}, {15,25}, {21,32}, {18,20} };
	// This is a smaller board
	private static final int NUM_SQUARES = 12;
	private static final int[][] FROM_TO = { {2,6} , {7,9} , {11,5} };
	private static final int[] DEATH_SQUARES = {4,8};
	public static void main(String[] args) {
		Game game = new Game(PLAYER_NAMES, NUM_SQUARES, FROM_TO, DEATH_SQUARES);
		game.play();
	}
}
