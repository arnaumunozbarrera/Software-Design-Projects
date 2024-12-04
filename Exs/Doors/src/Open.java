public class Open extends CodeHandler{
  private String codeOpen;

  public Open(String code, CodeHandler nextHandler){
    super(nextHandler);
    codeOpen= code;
  }


  @Override
  public void handleCode(String code, Door door) {
    System.out.println("handle Open");
    if(!door.isLocked()){
      if(codeOpen.equals(code)){
        door.resetState();
        door.open();
      }else {
        door.incrementNumTrials();
        System.out.println(door.getNumTrials()+" trials");
        super.handleCode(code, door);
      }
    } else {
      //void, can't open until unlocked
    }
  }
}
