public class Unlock extends CodeHandler{
  private String code;

  public Unlock(String code, CodeHandler nextHandler){
    super(nextHandler);
    this.code = code;
  }

  @Override
  public void handleCode(String code1, Door door) {
    System.out.println("handle Unlock");
    if(door.isLocked()){
      if(code.equals(code1)){
        registro.add(new EntryLog(code1, door.getId(), door.isLocked()));
        door.resetState();
        System.out.println("Unlocked door");
      }
      else{
        System.out.println("Codigo de desbloqueo incorrecto");
      }
    } else {
      super.handleCode(code1,door);
    }
  }
}
