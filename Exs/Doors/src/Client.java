import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
  public static void main(String[] args) throws IOException {
    String openCode = "1111";
    String fireAlarmCode = "2222";
    String unlockCode = "3333";
    CodeHandler chain1 =
        new Log(new Unlock(unlockCode,
            new FireAlarm(fireAlarmCode,
                new Open(openCode,
                    new Lock(null)))));

    CodeHandler chain2 = new Log(new Open(openCode, null));
    CodeHandler chain3 =
        new Log(
            new FireAlarm(fireAlarmCode,
                new Open(openCode, null)));

    Door d1 = new Door("d1", chain1);

    System.out.println("--------------------------------------------Chain 1:");
    d1.processCode("1111");
    System.out.println("\n");
    d1.processCode("2222");
    System.out.println("\n");
    d1.processCode("1234");
    System.out.println("\n");
    d1.processCode("4321");
    System.out.println("\n");
    d1.processCode("5555");
    System.out.println("\n");
    d1.processCode("6666");
    System.out.println("\n");
    d1.processCode("7777");
    System.out.println("\n");
    d1.processCode("1111");
    System.out.println("\n");
    d1.processCode("3333");
    System.out.println("\n");
    d1.processCode("2222");
    System.out.println("\n");


    d1.setCodeHandler(chain2);
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      System.out.println("Input code: ");
      String inputCode = stdin.readLine();
      d1.processCode(inputCode);
    }
    /*
    System.out.println("--------------------------------------------Chain 2:");
    Door d2 = new Door("d2", chain2);

    d2.processCode("1111");
    System.out.println("\n");
    d2.processCode("2222");
    System.out.println("\n");
    d2.processCode("1234");
    System.out.println("\n");
    d2.processCode("4321");
    System.out.println("\n");
    d2.processCode("5555");
    System.out.println("\n");
    d2.processCode("6666");
    System.out.println("\n");
    d2.processCode("7777");
    System.out.println("\n");
    d2.processCode("1111");
    System.out.println("\n");
    d2.processCode("3333");
    System.out.println("\n");
    d2.processCode("2222");
    System.out.println("\n");

    System.out.println("--------------------------------------------Chain 3:");
    Door d3 = new Door("d3", chain3);

    d3.processCode("1111");
    System.out.println("\n");
    d3.processCode("2222");
    System.out.println("\n");
    d3.processCode("1234");
    System.out.println("\n");
    d3.processCode("4321");
    System.out.println("\n");
    d3.processCode("5555");
    System.out.println("\n");
    d3.processCode("6666");
    System.out.println("\n");
    d3.processCode("7777");
    System.out.println("\n");
    d3.processCode("1111");
    System.out.println("\n");
    d3.processCode("3333");
    System.out.println("\n");
    d3.processCode("2222");
    System.out.println("\n");

     */
  }
}
