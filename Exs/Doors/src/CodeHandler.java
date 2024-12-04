import java.util.ArrayList;

public abstract class CodeHandler {
  protected CodeHandler nextHandler;
  protected ArrayList<EntryLog> registro;


  public CodeHandler(CodeHandler nextHandler){
    this.nextHandler = nextHandler;
    registro = new ArrayList<EntryLog>();
  }

  public void handleCode(String code, Door door) {
    if(nextHandler != null){
      nextHandler.handleCode(code, door);
    }
  }
}
