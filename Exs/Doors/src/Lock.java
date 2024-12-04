public class Lock extends CodeHandler{

  public Lock(CodeHandler nextHandler){
    super(nextHandler);
  }


  @Override
  public void handleCode(String code, Door door) {
    System.out.println("handle Lock");
    if(door.isLocked()){
      System.out.println("Door is already locked");
    }
    else{
      if(door.getNumTrials() >= 3) {
        door.lock();
        System.out.println("Door is Locked due to the amount of trials");
      }
    }
    super.handleCode(code,door);
  }

}
