public class FireAlarm extends CodeHandler {
  private String code;

  public FireAlarm(String code, CodeHandler nextHandler){
    super(nextHandler);
    this.code = code;
  }
  @Override
  public void handleCode(String code1, Door door) {
    System.out.println("handle FireAlarm");
    if(!door.isLocked()){
      if(code.equals(code1)){
        registro.add(new EntryLog(code1, door.getId(), door.isLocked()));
        door.open();
        System.out.println("Alarm activated");
      } else {
        super.handleCode(code1,door);
      }
    }
  }
}
