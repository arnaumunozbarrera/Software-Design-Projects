import java.util.ArrayList;

public class Door {


  private String id;
  private CodeHandler codeHandler;
  private int numTrials = 0;
  private boolean locked = false;

  public void resetState() { // static method because it changes static attributes
    numTrials = 0; locked = false; }

  public void incrementNumTrials() { numTrials++; }
  public int getNumTrials() { return numTrials; }
  public boolean isLocked() { return locked; }
  public void lock() { locked = true; }

  public Door(String ident, CodeHandler ch) {
    id = ident;
    codeHandler = ch;
  }

  public void processCode(String code) { codeHandler.handleCode(code, this); }
  public void open() { System.out.println("door " + id + " opened"); }
  public String getId() { return id; }
  public void setCodeHandler(CodeHandler ch) { codeHandler = ch; }
}
