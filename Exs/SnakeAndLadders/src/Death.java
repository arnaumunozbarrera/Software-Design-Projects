public class Death extends Square {
  public Death(int position, Board board) {
    super(position, board);
  }

  @Override
  public void enter(Player p) {
    p.setDead(true);
  }
}
