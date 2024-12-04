public class Square {
  protected Player player;
  protected int position;
  protected Board board;

  public Square(int pos, Board b) {
    position = pos;
    board = b;
  }

  public int getPosition() {
    return position;
  }

  protected Square landHereOrGoHome() {
    if (isOccupied()) {
      System.out.println("square " + (position + 1) + " is occupied, go to square 1");
      return findFirstSquare();
    } else {
      System.out.println("land at " + (position + 1));
      return this;
    }
  }

  public boolean isLastSquare() {
    return (position == board.numberOfSquares() - 1);
  }

  public void enter(Player p) {
    player = p;
    player.setSquare(this);
  }

  public void leave(Player p) {
    player = null;
  }

  public Square moveAndLand(int moves) {
    int lastPosition = board.lastSquare().getPosition();
    if (position + moves > lastPosition) {
      System.out.println("Should go to " + (position + moves + 1)
              + " beyond last square " + (lastPosition + 1)
              + " so don't move");
      return this;
    } else {
      System.out.println("move from " + (position + 1) + " to "
              + (findRelativeSquare(moves).getPosition() + 1));
      return findRelativeSquare(moves).landHereOrGoHome();
    }
  }

  protected boolean isOccupied() {
	  return player != null;
  }

  protected Square findRelativeSquare(int moves) {
	  return board.findSquare(moves + position);
  }

  protected Square findFirstSquare() {
	  return board.firstSquare();
  }
}
