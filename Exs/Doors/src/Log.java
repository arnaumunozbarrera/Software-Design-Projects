import java.util.ArrayList;

public class Log extends CodeHandler{

  public Log(CodeHandler nextHandle){
    super(nextHandle);
  }

  @Override
  public void handleCode(String code, Door door) {
    System.out.println("handle Log");
    super.handleCode(code,door);

    /*if(!registro.isEmpty()){
      for(EntryLog a : registro) System.out.println(a);
    }
    else{
      System.out.println("No se ha introducido ningun codigo");
    } */
  }
}
