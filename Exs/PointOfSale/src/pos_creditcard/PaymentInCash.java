package pos_creditcard;

import java.lang.invoke.StringConcatFactory;

public class PaymentInCash extends Payment {
  double amountHanded;

  private Cash caja;

  public PaymentInCash(double amountHanded,double amountToPay, double[] bitllets, int[] quantitat, String method, Cash cash) {
    super(amountToPay);
    assert amountHanded >= amountToPay;
    this.amountHanded = amountHanded;
    this.caja = cash;

    System.out.printf("\nMake change with " + method + " change maker\n");
    System.out.printf("\nMoney to add to the cash box: " + amountHanded + "\n");
    cash.addCash(bitllets, quantitat);
    System.out.printf("\nTotal to pay: " + amountToPay + ", change to give " + change() + "\n");
    System.out.printf("\nThe change is:\n");


    switch(method){

      case "greedy":
        cash.ChangeGreedy(change());
        break;

      case "random":
        cash.ChangeRandom(change());
        break;

      default:
        System.out.printf("Invalid method\n");

        break;
    }

    System.out.printf("After payment and giving change the cash box has:\n");
    cash.printCash();

  }



  private double change() {
    double change = amountHanded - amountToPay;
    assert change >= 0;
    return change;
  }

  @Override
  public void print() {
    /*System.out.printf("\nMake change with greedy change maker\n");
    System.out.printf("\nAmount handed : %.2f\nChange : %.2f\n", amountHanded);
    System.out.printf("\nAdded payment to cash box : %.2f\n Payment : %.2f\n", amountHanded);*/
  }
}
